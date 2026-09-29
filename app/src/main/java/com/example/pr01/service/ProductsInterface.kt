package com.example.pr01.service

import com.example.pr01.data.Productsresponce
import retrofit2.http.GET

interface ProductsInterface {
    @GET("products")

    suspend fun getproducts(): Productsresponce
}