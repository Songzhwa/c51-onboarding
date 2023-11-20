package com.c51.onboarding.ui.rv.adapter.builder

import com.c51.onboarding.ui.rv.adapter.RvViewHolder

const val NOT_IDENTIFIABLE = "unidentified"

abstract class BuilderItem(open val optionalId : String = NOT_IDENTIFIABLE) {
    abstract fun getViewType(): Int
    abstract fun render(holder: RvViewHolder)

    fun isIdentifiable(): Boolean = optionalId != NOT_IDENTIFIABLE
}