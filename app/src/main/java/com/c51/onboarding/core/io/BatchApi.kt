package com.c51.onboarding.core.io

import com.c51.onboarding.feature.offers.data.DynamicBatchData
import com.c51.onboarding.feature.offers.data.ListCategoryResults
import com.c51.onboarding.feature.bonus.BonusPlanV3
import com.c51.onboarding.feature.offers.data.StaticBatchData
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface BatchApi {
    @GET("/v3/bonus-plan/abbreviated/{id}")
    fun getBonusPlan(@Path("id")  id: Int): Flowable<BonusPlanV3>

    @GET("/v2/batches/current/static")
    fun getStatic(): Flowable<StaticBatchData>

    @GET("/v2/batches/current/dynamic")
    fun getDynamic(): Flowable<DynamicBatchData>

    @GET("/v1/getListCategories")
    fun getCategories(): Flowable<ListCategoryResults>
}