package com.example.pr01.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val loggingInterceptor = HttpLoggingInterceptor().apply{
        level = HttpLoggingInterceptor.Level.BODY
    }



    val httpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .addInterceptor(loggingInterceptor)
        .build()

    private val api: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.207.106.59:8090/api/collections/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofit: Retrofit= Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    val retrofitAPI: ProductInterface =retrofit.create(ProductInterface::class.java)

    val recipesService: RecipeService = retrofit.create(RecipeService::class.java)

    val usersService: UserService = retrofit.create(UserService::class.java)

    val productsSerice: ProductInterface = retrofit.create(ProductInterface::class.java)

    val authService:AuthService =api.create(AuthService::class.java)

    val recipeServiceAuth: RecipeServiceAuth = api.create(RecipeServiceAuth::class.java)


}