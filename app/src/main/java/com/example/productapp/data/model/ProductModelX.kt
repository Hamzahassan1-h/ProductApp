package com.example.productapp.data.model


import com.google.gson.annotations.SerializedName

data class ProductModelX(
    @SerializedName("availabilityStatus")
    val availabilityStatus: String? = "",
    @SerializedName("brand")
    val brand: String? = "",
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("discountPercentage")
    val discountPercentage: Double? = 0.0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("images")
    val images: List<String?>? = listOf(),
    @SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int? = 0,
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("rating")
    val rating: Double? = 0.0,
    @SerializedName("returnPolicy")
    val returnPolicy: String? = "",
    @SerializedName("shippingInformation")
    val shippingInformation: String? = "",
    @SerializedName("sku")
    val sku: String? = "",
    @SerializedName("stock")
    val stock: Int? = 0,
    @SerializedName("tags")
    val tags: List<String?>? = listOf(),
    @SerializedName("thumbnail")
    val thumbnail: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("warrantyInformation")
    val warrantyInformation: String? = "",
    @SerializedName("weight")
    val weight: Int? = 0
)