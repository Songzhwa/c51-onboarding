package com.c51.onboarding.feature.offers.data

import com.google.gson.annotations.SerializedName

data class ListCategoryResults(
    val result: String,
    @SerializedName("list_categories")
    val categories: List<CategoryData>
)

data class CategoryData(
    @SerializedName("list_category_id")
    val id: Int = 0,
    val name: String = "",
    val ordinal: Int = 0, // Order to show categories, smaller first
    @SerializedName("elevated_category_image_url")
    val elevatedCategoryImageUrl : String?,
    @SerializedName("copy_text")
    val textBody: String?,
    @SerializedName("offers")
    val offerIdToOrdinalMapping: Map<String, Int>?
) {
    fun isElevatedCategory(): Boolean = elevatedCategoryImageUrl != null && textBody != null
}