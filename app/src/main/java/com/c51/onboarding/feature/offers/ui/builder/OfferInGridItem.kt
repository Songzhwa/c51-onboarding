package com.c51.onboarding.feature.offers.ui.builder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.c51.onboarding.R
import com.c51.onboarding.ext.setDivider
import com.c51.onboarding.feature.offers.data.OfferData
import com.c51.onboarding.ui.rv.adapter.RvViewHolder
import com.c51.onboarding.ui.rv.adapter.builder.BuilderItem
import com.c51.onboarding.ui.rv.adapter.oneadapter.OneAdapter

class OfferInGridItem(val offers: List<OfferData>) : BuilderItem() {
    override fun getViewType(): Int = R.layout.item_rv

    override fun render(vh: RvViewHolder) {
        val ctx = vh.rootView<View>().context
        val rowAdapter = object: OneAdapter<OfferData>(R.layout.item_offer_card_grid, offers) {
            override fun apply(cardVH: RvViewHolder, offer: OfferData, position: Int) {
                cardVH.setText(R.id.tvOfferName, offer.static.name)
                cardVH.setText(R.id.tvOfferSeller, "All Store")
                cardVH.setText(R.id.tvOfferCashback, offer.static.cashback.amount)
                cardVH.setImage(R.id.ivOfferProduct, offer.static.imageUrl)
            }
        }
        val rv = vh.getView<RecyclerView>(R.id.rvGridOffers)
        rv.layoutManager = LinearLayoutManager(ctx, RecyclerView.HORIZONTAL, false)
        rv.adapter = rowAdapter
        rv.setDivider(RecyclerView.HORIZONTAL)
    }
}