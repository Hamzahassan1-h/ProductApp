package com.example.productapp

import com.example.productapp.data.model.ProductModel
import com.example.productapp.data.model.ProductModelX
import com.example.productapp.data.remote.repo.ProductRepository
import com.example.productapp.data.remote.repo.ProductRepositoryImpl
import com.example.productapp.data.remote.service.ProductService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@ExperimentalCoroutinesApi
class ProductRepositoryImplTest {

    @get:Rule
    var rule: MockitoRule? = MockitoJUnit.rule()

    @Mock
    private lateinit var productService: ProductService

    private lateinit var productRepository: ProductRepository

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        productRepository = ProductRepositoryImpl(productService)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
    @Test
    fun `getProducts should emit a list of products`() = runTest {
        // Arrange
        val expectedProducts = listOf(
            ProductModelX(id = 1, title = "Product 1"),
            ProductModelX(id = 2, title = "Product 2")
        )
        val productsModel = ProductModel(products = expectedProducts)
        `when`(productService.getProducts()).thenReturn(productsModel)

        // Act
        val result = productRepository.getProducts().toList()

        // Assert
        assertEquals(1, result.size) // Since Flow emits one list of products
        assertEquals(expectedProducts, result[0])
    }
}