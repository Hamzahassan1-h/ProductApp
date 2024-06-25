package com.example.productapp

import com.example.productapp.data.model.ProductModelX
import com.example.productapp.data.remote.repo.ProductRepository
import com.example.productapp.ui.viewmodels.ProductListViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


//@RunWith(MockitoJUnitRunner::class):
//This annotation tells JUnit to use the MockitoJUnitRunner to run the test.
//It initializes the mocks and handles some of the boilerplate code for Mockito.
@RunWith(MockitoJUnitRunner::class)
class ProductListViewModelTest {
    //@Mock: This annotation is used to declare a mock object.
    // In this case, repository is mocked to simulate the behavior of ProductRepository.
    @Mock
    private lateinit var repository: ProductRepository

    //This declares the viewModel which will be initialized in the setUp method.
    private lateinit var viewModel: ProductListViewModel

    //@ExperimentalCoroutinesApi:
    //This annotation indicates that the test uses experimental coroutines features.
    @ExperimentalCoroutinesApi
    @get:Rule

    //This declares and initializes the MainCoroutineRule
    //to replace the main dispatcher with a test dispatcher.
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        //Initializes the mocks.
        MockitoAnnotations.openMocks(this)

        // Initializes the ProductListViewModel with the mocked repository.
        viewModel = ProductListViewModel(repository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `fetchProducts should update productList`() = runTest {
        //runTest: A coroutine test function that allows the use of coroutines in the test.
        //expectedProducts: A list of ProductModelX objects representing the expected products.
        val expectedProducts = listOf(
            ProductModelX(id = 1, images = emptyList(), title = "Product 1"),
            ProductModelX(id = 2, images = emptyList(), title = "Product 2")
        )
        //Mocks the getProducts method to return a flow containing expectedProducts.
        whenever(repository.getProducts()).thenReturn(flowOf(expectedProducts))

        //Calls the fetchProducts method in the ProductListViewModel to start fetching products.
        viewModel.fetchProducts()

        //Launches a coroutine to collect the products from
        //viewModel.productList and assert that they match the expectedProducts.
        val job = launch {
            viewModel.productList.collect { products ->
                assertEquals(expectedProducts, products)
            }
        }
        //Cancels the coroutine job after the assertion.
        job.cancel()
    }
}
//This test ensures that the ProductListViewModel correctly updates its productList state
//when fetchProducts is called and the repository returns the expected products.