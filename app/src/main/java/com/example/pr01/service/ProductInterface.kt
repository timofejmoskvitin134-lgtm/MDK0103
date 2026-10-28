package com.example.pr01.service

import com.example.pr01.data.DeletedProductResponse
import com.example.pr01.data.Productresponce
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductInterface {
    @GET("products")
    suspend fun getproducts(): Productresponce

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") productId: Int): DeletedProductResponse
}
