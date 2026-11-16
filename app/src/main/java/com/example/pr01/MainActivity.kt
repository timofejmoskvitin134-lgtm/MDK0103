package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pr01.ViewModel.LoginViewModel
import com.example.pr01.ViewModel.RecipesViewModel
import com.example.pr01.data.AuthRequest
import com.example.pr01.service.TokenManager
import com.example.pr01.ui.RecipesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tokenManager = TokenManager(applicationContext)

        val recipesViewModel: RecipesViewModel by viewModels {
            viewModelFactory {
                initializer {
                    RecipesViewModel(tokenManager)
                }
            }
        }

        val loginViewModel: LoginViewModel by viewModels {
            viewModelFactory {
                initializer {
                    LoginViewModel(tokenManager, recipesViewModel)
                }
            }
        }

        setContent {
            LaunchedEffect(Unit) {
                val authRequest = AuthRequest(
                    identity = "timofejmoskvitin134@gmail.com",
                    password = "Password123!"
                )
                loginViewModel.login(authRequest)
            }

            RecipesScreen(viewModel = recipesViewModel)
        }
    }
}
