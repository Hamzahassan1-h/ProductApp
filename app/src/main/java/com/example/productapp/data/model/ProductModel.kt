package com.example.productapp.data.model


import com.google.gson.annotations.SerializedName

data class ProductModel(
//    @SerializedName("limit")
//    val limit: Int? = 0,
    @SerializedName("products")
    val products: List<ProductModelX>
//    @SerializedName("skip")
//    val skip: Int? = 0,
//    @SerializedName("total")
//    val total: Int? = 0
)