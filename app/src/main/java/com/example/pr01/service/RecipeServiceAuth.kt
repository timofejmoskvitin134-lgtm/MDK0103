package com.example.pr01.service

import com.example.pr01.data.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface RecipeServiceAuth {

    @GET("recipes/records")
    suspend fun getRecipeAuth(@Header("Authorization") token: String): RecipesResponse
}