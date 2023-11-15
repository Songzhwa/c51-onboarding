package com.c51.onboarding.feature.offers.data

import com.c51.onboarding.core.BaseViewModel
import com.c51.onboarding.core.io.BatchApi
import com.c51.onboarding.ext.schedules
import io.reactivex.rxjava3.core.Flowable

class OfferListViewModel(val api: BatchApi) : BaseViewModel() {
    val batchRequest = Flowable.zip(
        api.getStatic(), api.getDynamic(), api.getCategories()
    ) { staticResponse, dynamicResponse, categoryResponse ->
        organizedOfferListData(staticResponse, dynamicResponse, categoryResponse)
    }
        .schedules()
}