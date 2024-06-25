package com.example.productapp.di

import androidx.compose.ui.tooling.preview.Preview
import com.example.productapp.data.remote.repo.ProductRepository
import com.example.productapp.data.remote.repo.ProductRepositoryImpl
import com.example.productapp.data.remote.service.ApiDetails
import com.example.productapp.data.remote.service.ProductService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepositoryApi(): ProductService {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductService::class.java)
    }
    @Provides
    @Singleton
    fun provideProductRepository(api: ProductService): ProductRepository {
        return ProductRepositoryImpl(api)
    }
}