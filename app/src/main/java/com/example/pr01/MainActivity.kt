package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pr01.ViewModel.RecipesViewModel
import com.example.pr01.data.Recipe

class MainActivity : ComponentActivity() {

    private val viewModel: RecipesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val recipe = Recipe(
                name = "Запеченный лосось в лимонно-горчичном маринаде",
                ingredients = listOf(
                    "Стейк или филе лосося", "Лимонный сок", "Горчица дижонская",
                    "Оливковое масло", "Мед", "Чеснок", "Соль", "Свежемолотый черный перец"
                ),
                difficulty = "Легкая",
                caloriesPerServing = 420
            )

            LaunchedEffect(Unit) {
                viewModel.addProducts(recipe)
            }

            viewModel.addedRecipe?.let { recipe ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    item {
                        Column {
                            Text(text = "Название: ${recipe.name}")
                            Text(text = "Сложность: ${recipe.difficulty}")
                            Text(text = "Калорийность: ${recipe.caloriesPerServing} ккал")
                            Text(text = "Ингредиенты:")
                        }
                    }
                    items(recipe.ingredients) { ingredient ->
                        Text(text = "- $ingredient")
                    }
                }
            }
        }
    }
}