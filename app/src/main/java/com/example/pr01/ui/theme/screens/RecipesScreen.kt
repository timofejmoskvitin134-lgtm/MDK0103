package com.example.pr01.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pr01.ViewModel.RecipesViewModel
import com.example.pr01.components.RecipesContent

@Composable
fun RecipesScreen(viewModel: RecipesViewModel) {
    val recipes by viewModel.recipes.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    RecipesContent(
        recipes = recipes,
        isLoading = isLoading,
        error = error
    )
}
