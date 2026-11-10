package com.example.pr01.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.pr01.service.RetrofitClient
import com.example.pr01.service.TokenManager
import kotlinx.coroutines.launch

class RecipesViewModel(val tokenManager: TokenManager): ViewModel() {


    fun getRecipes(){
        viewModelScope.launch{
            try {
                val token = tokenManager.tokenFlow()
                token?.let{
                    val recipesResponse = RetrofitClient.recipeServiceAuth.getRecipeAuth(token)
                    for(item in recipesResponse.items){
                        Log.d("RecipesViewModel","id: ${item.id}" +
                                "\nname: ${item.name}" +
                                "\ndifficulty: ${item.difficulty}" +
                                "\ncreated: ${item.created}" +
                                "\nupdated: ${item.updated}")
                    }

                }


            }catch (e: Exception){
                Log.e("RecipesViewModel", e.message.toString())

            }
        }
    }
}