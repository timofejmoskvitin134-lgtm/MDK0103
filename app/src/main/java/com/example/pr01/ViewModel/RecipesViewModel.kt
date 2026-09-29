package com.example.pr01.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.Recipe
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch


class RecipesViewModel : ViewModel() {

    var addedRecipe by mutableStateOf<Recipe?>(null)
        private set

    var statusMessage by mutableStateOf("")
        private set

    fun addProducts(recipe: Recipe) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.retrofitAPI.addRecipe(recipe)
                addedRecipe = response
                statusMessage = "ДОБАВЛЕН!"
                println("LOG_TAG_API: РАБОТАЕТ ${response.id}")
            } catch (e: Exception) {
                println("LOG_TAG_API: не работает ${e.localizedMessage}")
                e.printStackTrace()
                statusMessage = "Ошибка запроса."
            }
        }

    }
}