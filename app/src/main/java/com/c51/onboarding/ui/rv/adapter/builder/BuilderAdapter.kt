package com.c51.onboarding.ui.rv.adapter.builder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c51.onboarding.ui.rv.adapter.RvViewHolder

class BuilderAdapter(val data: MutableList<BuilderItem>) : RecyclerView.Adapter<RvViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val datum = data[position]
        return datum.getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder =
        RvViewHolder.createViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        if (data.size > position) {
            val datum = data[position]
            datum.render(holder)
        }
    }

    override fun getItemCount() = data.size

}