package com.example.productapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.data.model.ProductModelX
import com.example.productapp.data.remote.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel(){

    private var _productList =  MutableStateFlow<List<ProductModelX>>(emptyList())
    val productList: StateFlow<List<ProductModelX>> get() = _productList

    init {
        fetchProducts()
    }
    fun fetchProducts(){
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.getProducts().collect{ productList ->
                _productList.value = productList.filterNotNull()

            }
        }
    }

}