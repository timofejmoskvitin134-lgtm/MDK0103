package com.example.pr01.service
import com.example.pr01.data.AuthRequest
import com.example.pr01.data.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthService {

    @POST("users/auth-with-password")
    suspend fun authPassword(@Body authRequest: AuthRequest): AuthResponse
}