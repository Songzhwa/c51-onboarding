package com.c51.onboarding.feature.bonus

import com.google.gson.annotations.SerializedName
import java.util.Date

// the data schema is from : "v3/bonus-plan/abbreviated/{id}"
data class BonusPlanV3(
    @SerializedName("bonus_plan_id") var bonusPlanId: Int,
    @SerializedName("cash_back_amount") var cashBackAmount: String,
    @SerializedName("cash_back_currency") var cashbackCurrency: String,
    @SerializedName("batch_start_date") var startDate: Date,
    @SerializedName("batch_end_date") var endDate: Date,
    var name: String,
    var description: String,
    var offers: ArrayList<BonusPlanOfferV3>,
)

data class BonusPlanOfferV3(
    @SerializedName("offer_id") var offerId : Int,
    var name: String,
    var image: String,
)