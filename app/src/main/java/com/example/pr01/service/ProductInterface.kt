package com.example.pr01.service

import com.example.pr01.data.Productresponce
import retrofit2.http.GET

interface ProductInterface {
    @GET("products")

    suspend fun getproducts(): Productresponce
}