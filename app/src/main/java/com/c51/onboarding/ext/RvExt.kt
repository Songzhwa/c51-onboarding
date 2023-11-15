package com.c51.onboarding.ext

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.c51.onboarding.R

fun RecyclerView.setDivider(@RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL) {
    val divider = DividerItemDecoration(context, orientation)
    ContextCompat.getDrawable(context, R.drawable.horizontal_divider)?.let { drawable ->
        divider.setDrawable(drawable)
        if (itemDecorationCount == 0) {
            addItemDecoration(divider)
        }
    }
}