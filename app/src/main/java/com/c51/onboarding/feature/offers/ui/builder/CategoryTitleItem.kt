package com.c51.onboarding.feature.offers.ui.builder

import com.c51.onboarding.R
import com.c51.onboarding.ui.rv.adapter.RvViewHolder
import com.c51.onboarding.ui.rv.adapter.builder.BuilderItem

class CategoryTitleItem(private val title: String, private val count: Int) : BuilderItem() {
    override fun getViewType() = R.layout.item_offers_title

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tvSectionTitle, title)
        holder.setText(R.id.tvSectionCount, count.toString())
    }
}