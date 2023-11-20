package com.c51.onboarding.feature.offers.ui

import android.os.Bundle
import android.util.Size
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.c51.onboarding.R
import com.c51.onboarding.core.BaseActivity
import com.c51.onboarding.ext.aligns
import com.c51.onboarding.ext.clearedBy
import com.c51.onboarding.ext.setDivider
import com.c51.onboarding.feature.offers.data.BatchData
import com.c51.onboarding.feature.offers.data.OfferListViewModel
import com.c51.onboarding.feature.offers.ui.builder.CategoryTitleItem
import com.c51.onboarding.feature.offers.ui.builder.InvisibleDividerItem
import com.c51.onboarding.feature.offers.ui.builder.OfferInGridItem
import com.c51.onboarding.feature.offers.ui.builder.OfferInListItem
import com.c51.onboarding.ui.rv.adapter.builder.BuilderAdapterWrapper
import kotlinx.android.synthetic.main.activity_offer_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class OfferListActivity : BaseActivity(R.layout.activity_offer_list) {
    private val vm: OfferListViewModel by viewModel()
    private var batch: BatchData? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rvOfferList.layoutManager = LinearLayoutManager(this)
        rvOfferList.setDivider()

        switchMode.setOnCheckedChangeListener { buttonView, isChecked ->
            switchMode.text = if (isChecked) "Grid" else "List"
            renderPage(batch)
        }

        vm.batchRequest
            .aligns(this::onStartLoading, this::onLoaded)
            .subscribe { batchValue ->
                batch = batchValue
                renderPage(batchValue)
            }.clearedBy(disposables)
    }

    private fun renderPage(batch: BatchData?) {
        val viewMode = switchMode.text.toString()
        if ("list".equals(viewMode, true)) {
            renderOfferList(batch)
        } else {
            renderOfferGrid(batch)
        }
    }

    private fun renderOfferList(batch: BatchData?) {
        if (batch == null) return

        //TODO re-order the orders based on the "subcategory is on/off"

        val wrapper = BuilderAdapterWrapper()
        batch.categoriesWithOffer.forEach { rowData ->
            wrapper.add(CategoryTitleItem(rowData.category.name, rowData.offers.size))
            wrapper.add(InvisibleDividerItem(Size(1, 8)))
            rowData.offers.forEach { offerData ->
                wrapper.add(OfferInListItem(offerData))
                wrapper.add(InvisibleDividerItem(Size(1, 4)))
            }
            wrapper.add(InvisibleDividerItem(Size(1, 12)))
        }
        rvOfferList.adapter = wrapper.generateAdapter()
    }

    private fun renderOfferGrid(batch: BatchData?) {
        if (batch == null) return
        val wrapper = BuilderAdapterWrapper()

        //TODO re-order the orders based on the "subcategory is on/off"

        batch.categoriesWithOffer.forEach { rowData ->
            wrapper.add(CategoryTitleItem(rowData.category.name, rowData.offers.size))
            wrapper.add(InvisibleDividerItem(Size(1, 8)))
            wrapper.add(OfferInGridItem(rowData.offers))
            wrapper.add(InvisibleDividerItem(Size(1, 12)))
        }
        rvOfferList.adapter = wrapper.generateAdapter()
    }

    private fun onStartLoading() {
        rvOfferList.isVisible = false
        shimmer.isVisible = true
        shimmer.startShimmer()
    }

    private fun onLoaded() {
        rvOfferList.isVisible = true
        shimmer.isVisible = false
        shimmer.stopShimmer()
    }
}