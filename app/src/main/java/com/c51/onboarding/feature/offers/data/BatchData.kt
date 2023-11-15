package com.c51.onboarding.feature.offers.data


data class OfferData(
    val static: StaticOfferData,
    val dynamic: DynamicOfferData,
    var categories: List<CategoryData> = emptyList()
)

data class BatchSectionData(
    val category: CategoryData,
    val offers: List<OfferData>,
)

data class BatchData(
    val hsb: List<HsbHighlight>, //hsb: home screen banner
    val bonuses: List<StaticBonusPlan>,
    val featureOffers: List<OfferData>,
    val topPickOffers: List<OfferData>,
    val categoriesWithOffer: List<BatchSectionData>,
)


fun organizedOfferListData(static: StaticBatchData, dynamic: DynamicBatchData, categories: ListCategoryResults): BatchData {
    val hsb = arrayListOf<HsbHighlight>()
    dynamic.highlights?.forEach { dh ->  // dynamic highlight
        val hsbItem = static.highlights?.find { sh -> sh.id == dh.id }
        if (hsbItem != null) {
            hsb.add(hsbItem)
        }
    }

    val bonuses = arrayListOf<StaticBonusPlan>()
    dynamic.bonusPlans?.forEach { db ->  // dynamic bonus
        val bonusItem = static.bonusPlans?.find { sb -> sb.bonusPlanId == db.bonusPlanId }
        if (bonusItem != null) {
            bonuses.add(bonusItem)
        }
    }

    val allOffers = arrayListOf<OfferData>()
    // dynamic约90来个offer, static可能有200多个offer, 为了少比较一点, 这里用dynamic里的offer来做forEach, 而不用staticResp.offers来做forEach
    dynamic.offers.forEach { dynamicOffer ->
        val offerId = dynamicOffer.offerId
        val staticOffer = static.offers.find { it.offerId == offerId } ?: return@forEach
        allOffers.add(OfferData(staticOffer, dynamicOffer))
    } // 只有当一个Offer在static, dynamic中都有, 才能显示这个offer

    val featureOffers = allOffers.filter { offer -> offer.static.featured }

    val topPickOffers = allOffers.filter { offer -> offer.static.topPick }

    val rows = arrayListOf<BatchSectionData>()
    categories.categories.forEach { category ->
        val cid = category.id
        val offersOfThisRow = allOffers.filter { offer -> offer.static.categoryAisleId.contains(cid) }
        if (offersOfThisRow.isNotEmpty()) {
            rows.add(BatchSectionData(category, offersOfThisRow))
        }
    }
    return BatchData(hsb, bonuses, featureOffers, topPickOffers, rows)
}


