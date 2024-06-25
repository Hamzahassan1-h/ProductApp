package com.example.productapp.data.remote.repo

import com.example.productapp.data.model.ProductModelX
import kotlinx.coroutines.flow.Flow

//An interface in Kotlin defines a set of methods that a class must implement.
// It doesn't provide the implementation itself, only the method signatures.
//The return type of the getProducts function is a Flow of a List of ProductModelX?.List<ProductModelX?>:
//This specifies that the Flow will emit a list of ProductModelX objects.
//The ? indicates that each ProductModelX in the list can be nullable.
// This means that the list can contain ProductModelX objects or null values.
interface ProductRepository {
    fun getProducts(): Flow<List<ProductModelX?>>
}