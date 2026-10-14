package com.example.pr01.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.Recipe
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {

    fun createRecipe(recipe: Recipe) {
        viewModelScope.launch {
            try {
                val newRecipe = RetrofitClient.recipesService.createRecipe(recipe)
                Log.d(
                        "RecipeViewModel",
                                "Название - ${newRecipe.name}  " +
                                "\nИнгредиенты - ${newRecipe.ingredients}" +
                                "\nСложность - ${newRecipe.difficulty}" +
                                "\nКаллорийность - ${newRecipe.caloriesPerServing}"

                    )

                } catch (e: Exception) {
                    Log.e("RecipeViewModel", "${e.message}", e)
                }
        }
    }
}
