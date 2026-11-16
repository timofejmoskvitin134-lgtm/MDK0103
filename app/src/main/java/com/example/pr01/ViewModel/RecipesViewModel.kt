package com.example.pr01.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.Recipes
import com.example.pr01.service.RetrofitClient
import com.example.pr01.service.TokenManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipesViewModel(val tokenManager: TokenManager) : ViewModel() {

    private val _recipes = MutableStateFlow<List<Recipes>>(emptyList())
    val recipes: StateFlow<List<Recipes>> = _recipes.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun getRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val token = tokenManager.tokenFlow()
                if (token != null) {
                    val recipesResponse = RetrofitClient.recipeServiceAuth.getRecipeAuth(token)
                    _recipes.value = recipesResponse.items
                    for (item in recipesResponse.items) {
                        Log.d(
                            "RecipesViewModel",
                            "id: ${item.id}\nname: ${item.name}\ndifficulty: ${item.difficulty}"
                        )
                    }
                } else {
                    _error.value = "Токен авторизации не найден"
                }
            } catch (e: Exception) {
                Log.e("RecipesViewModel", e.message.toString())
                _error.value = "Ошибка загрузки: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
