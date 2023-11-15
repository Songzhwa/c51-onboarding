package com.c51.onboarding.ui.rv.adapter.oneadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c51.onboarding.ui.rv.adapter.RvViewHolder

abstract class OneAdapter<T> : RecyclerView.Adapter<RvViewHolder> {
    private var layoutResId: Int = 0
    var data: List<T>? = null

    constructor(layoutResId: Int) {
        this.layoutResId = layoutResId
        data = ArrayList()
    }

    constructor(layoutResId: Int, data: List<T>) {
        this.layoutResId = layoutResId
        this.data = data
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder.createViewHolder(parent, layoutResId)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        if (data != null && data!!.size > position) {
            apply(holder, data!![position], position)
        }
    }

    protected abstract fun apply(vh: RvViewHolder, value: T, position: Int)

}