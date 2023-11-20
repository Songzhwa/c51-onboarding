package com.c51.onboarding.feature.offers.ui.builder

import com.c51.onboarding.R
import com.c51.onboarding.feature.offers.data.OfferData
import com.c51.onboarding.ui.rv.adapter.RvViewHolder
import com.c51.onboarding.ui.rv.adapter.builder.BuilderItem

class OfferInListItem(val offer: OfferData) : BuilderItem() {
    override fun getViewType(): Int = R.layout.item_offer_card_list

    override fun render(vh: RvViewHolder) {
        vh.setText(R.id.tvOfferName, offer.static.name)
        vh.setText(R.id.tvOfferSeller, "All Store")
        vh.setText(R.id.tvOfferCashback, offer.static.cashback.amount)
        vh.setImage(R.id.ivOfferProduct, offer.static.imageUrl)
    }
}