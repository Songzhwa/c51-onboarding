package com.c51.onboarding.ui.rv.adapter.builder

import androidx.recyclerview.widget.RecyclerView
import com.c51.onboarding.ui.rv.adapter.RvViewHolder

class BuilderAdapterWrapper {
    val list = arrayListOf<BuilderItem>()

    fun addSection(vararg items: BuilderItem, precondition: (() -> Boolean) = { true }) {
        if (precondition()) {
            list.addAll(items)
        }
    }

    private fun addSectionAt(index: Int, vararg items: BuilderItem){
        list.addAll(index, items.toList())
    }

    fun addSectionBelow(vararg items: BuilderItem, sectionMatcher: (BuilderItem) -> Boolean) :Int? {
        var indexAdded : Int? = null
        list.find { sectionMatcher.invoke(it) }?.run {
            indexAdded = list.indexOf(this) + 1
            addSectionAt(indexAdded!!, *items)
        }
        return indexAdded
    }

    fun add(item: BuilderItem) {
        list.add(item)
    }

    fun clear() {
        list.clear()
    }

    fun generateAdapter(): RecyclerView.Adapter<RvViewHolder> {
        return BuilderAdapter(list)
    }

    fun generateBuilderAdapter(): BuilderAdapter = generateAdapter() as BuilderAdapter
}