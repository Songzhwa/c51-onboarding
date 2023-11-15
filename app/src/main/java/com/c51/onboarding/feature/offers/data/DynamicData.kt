package com.c51.onboarding.feature.offers.data

import com.google.gson.annotations.SerializedName
import java.util.*


data class DynamicBatchData(
    val batchId: Int,
    val startDate: Date,
    val endDate: Date,
    val offers: ArrayList<DynamicOfferData>,
    val bonusPlans: ArrayList<DynamicBonusPlan>? = arrayListOf(),
    val highlights: List<HighlightDynamicData>?, // highlights can be null
)

data class DynamicOfferData(
    val offerId: Int,
    // "claimsRemaining" is only for this user. It usually is "maxClaims - claims" for this user when the stock is abundant.
    // Note that, if the remaining is "zero left", then this `claimsRemaining` would be 0 as well
    val claimsRemaining: Int,
    @SerializedName("multiclaim")
    val isMultiClaim: Boolean,
    // "remaining" is for this offer's stock, not for this user. see: https://newsamerica.atlassian.net/wiki/spaces/CPD/pages/4493770785/Offer+card+icons
    val remaining: String,
    // how many offers has this user claimed
    val claims: Int,
    // what's the max claim for one single user (ignoring the stock)
    val maxClaims: Int,
)

data class DynamicBonusPlan(val bonusPlanId: Int)

data class HighlightDynamicData(
    @SerializedName("highlightId")
    val id: Int
)