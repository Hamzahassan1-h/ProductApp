package com.example.productapp.data.remote.repo


import com.example.productapp.data.model.ProductModelX
import com.example.productapp.data.remote.service.ProductService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl (
    //The class has a primary constructor that takes one parameter:
    //productService: An instance of ProductService.
    // This is a dependency that the ProductRepositoryImpl will use to fetch products.
    // It's marked as private to restrict its visibility to within the class.
    private val productService: ProductService
): ProductRepository{
    override fun getProducts(): Flow<List<ProductModelX>> = flow {
        val productResponse = productService.getProducts()
        emit(productResponse.products)
    }
}