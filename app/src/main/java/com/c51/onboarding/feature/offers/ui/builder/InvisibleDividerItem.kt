package com.c51.onboarding.feature.offers.ui.builder

import android.util.Size
import android.view.View
import com.c51.onboarding.R
import com.c51.onboarding.ext.dpToPx
import com.c51.onboarding.ui.rv.adapter.RvViewHolder
import com.c51.onboarding.ui.rv.adapter.builder.BuilderItem

class InvisibleDividerItem(val size: Size) : BuilderItem() {
    override fun getViewType(): Int = R.layout.item_invisible_divider

    override fun render(holder: RvViewHolder) {
        holder.getView<View>(R.id.itemInvisibleDivider).apply {
            val layoutParams = layoutParams
            layoutParams.width = size.width.dpToPx()
            layoutParams.height = size.height.dpToPx()
            setLayoutParams(layoutParams)
        }
    }
}