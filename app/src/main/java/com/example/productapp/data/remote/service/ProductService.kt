package com.example.productapp.data.remote.service

import com.example.productapp.data.model.ProductModel
import retrofit2.http.GET

interface ProductService {

    @GET(ApiDetails.PRODUCT_ENDPOINT)
    suspend fun getProducts(): ProductModel
}