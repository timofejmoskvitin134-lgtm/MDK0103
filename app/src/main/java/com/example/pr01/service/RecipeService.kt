package com.example.pr01.service

import com.example.pr01.data.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipeService {

    @POST("recipe/add")
    suspend fun createRecipe(@Body recipe: Recipe): Recipe
}