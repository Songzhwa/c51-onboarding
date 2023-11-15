package com.c51.onboarding.feature.offers.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class StaticBatchData(
    var batchId: Long,
    var startDate: Date,
    var endDate: Date,
    var userLanguage: String?,
    var offers: ArrayList<StaticOfferData>,
    val highlights: List<HsbHighlight>?, // highlights can be null
    val bonusPlans: ArrayList<StaticBonusPlan>? = arrayListOf()
)

data class StaticOfferData(
    var offerId: Int,
    var name: String,
    var imageUrl: String,
    var backgroundColor: String,
    var featured: Boolean,
    var topPick: Boolean,
    var locked: Boolean,
    val hasBonus: Boolean,
    var stores: ArrayList<String>,
    var excludedStores: ArrayList<String>,
    val batchAisleId: Int?, // represents a section in the UI, under which the offer will be shown. It can be null for Featured and Top Pick offers
    val categoryAisleId: List<Int>, // some offers may carry values in categoryAisleId other than the value in batchAisleId so we need additionally to show those offers at the end of the UI Sections as per aisleId values in this array. The array cannot be null but can be empty
    var cashback: Cashback,
    var offerType: OfferType,
    var customContentUrl: String?,
    val unlockOfferUrl: String?,
)

data class StaticBonusPlan(
    val bonusPlanId: Int,
    val name: String,
    val description: String,
    val cashbacks: ArrayList<Cashback>,
    val offerIds: ArrayList<Int>
)


data class HsbHighlight(
    @SerializedName("highlightId")
    val id: Int,
    val image: String,
    val link: String?,
    val adId: String?,
    @SerializedName("fullBleedImage")
    val fullBleedImage: String?
)

data class Cashback(var amount: String, var currency: String)

enum class OfferType {
    @SerializedName("product")
    PRODUCT,

    @SerializedName("video")
    VIDEO,

    @SerializedName("sample")
    SAMPLE,

    @SerializedName("survey")
    SURVEY,

    @SerializedName("custom")
    PROGRAM,
}