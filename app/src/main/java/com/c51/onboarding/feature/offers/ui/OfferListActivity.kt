package com.c51.onboarding.feature.offers.ui

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.c51.onboarding.R
import com.c51.onboarding.core.BaseActivity
import com.c51.onboarding.ext.aligns
import com.c51.onboarding.ext.clearedBy
import com.c51.onboarding.ext.setDivider
import com.c51.onboarding.feature.offers.data.BatchData
import com.c51.onboarding.feature.offers.data.BatchSectionData
import com.c51.onboarding.feature.offers.data.OfferListViewModel
import com.c51.onboarding.ui.rv.adapter.RvViewHolder
import com.c51.onboarding.ui.rv.adapter.oneadapter.OneAdapter
import kotlinx.android.synthetic.main.activity_offer_list.rvOfferList
import kotlinx.android.synthetic.main.activity_offer_list.shimmer
import org.koin.androidx.viewmodel.ext.android.viewModel

class OfferListActivity : BaseActivity(R.layout.activity_offer_list) {
    private val vm: OfferListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.batchRequest
            .aligns(this::onStartLoading, this::onLoaded)
            .subscribe { batch ->
                renderPage(batch)
            }.clearedBy(disposables)
    }

    private fun renderPage(batch: BatchData) {
        rvOfferList.layoutManager = LinearLayoutManager(this)
        val adapter = object : OneAdapter<BatchSectionData>(R.layout.item_offer_card, batch.categoriesWithOffer) {
            override fun apply(vh: RvViewHolder, value: BatchSectionData, position: Int) {
                val offer = value.offers[0]
                vh.setText(R.id.tvOfferName, offer.static.name)
                vh.setText(R.id.tvOfferSeller, "All Store")
                vh.setText(R.id.tvOfferCashback, offer.static.cashback.amount)
                vh.setImage(R.id.ivOfferProduct, offer.static.imageUrl)
            }
        }
        rvOfferList.adapter = adapter
        rvOfferList.setDivider()
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