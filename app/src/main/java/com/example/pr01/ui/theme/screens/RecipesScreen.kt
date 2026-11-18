package com.example.pr01.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.ViewModel.RecipesViewModel


@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipesViewModel = viewModel()
) {

    val recipesList by viewModel.recipesList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getRecipes()
    }


    LazyColumn(
        modifier = modifier
            .padding(top = 64.dp)
            .padding(horizontal = 20.dp)
    )
    {


        items(recipesList) { recip ->
            RecipeCard(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                difficulty = recip.difficulty,
                name = recip.name

            )

        }

    }

}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
private fun RecipeScreenPrev() {
    RecipeScreen()
}