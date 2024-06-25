package com.example.productapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.productapp.data.model.ProductModelX
import com.example.productapp.ui.viewmodels.ProductListViewModel

@Composable
fun ProductListScreen(
    productListViewModel: ProductListViewModel = hiltViewModel()
){

    val productList by productListViewModel.productList.collectAsState()

    LazyColumn (
        modifier = Modifier.padding(top = 32.dp)
    ){
        items(productList) { product ->
            ProductItemView(product = product)
        }
    }

}
@Composable
fun ProductItemView(
    product: ProductModelX
){

    Row (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = rememberAsyncImagePainter(product.images?.get(0)), 
            contentDescription = product.title,
            modifier = Modifier.size(100.dp)
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Text(
                text = "${product.title}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${product.description}",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Category: ${product.category}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Price: ${product.price}")
            
        }
    }
}