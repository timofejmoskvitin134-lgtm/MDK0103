package com.example.pr01.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pr01.data.Recipes

@Composable
fun RecipeCard(
    recipe: Recipes,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color(0x1A8A959E),
                spotColor = Color(0x268A959E)
            ),
        shape = RoundedCornerShape(8.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = recipe.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF808080)
            )
            Text(
                text = recipe.difficulty,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
        }
    }
}
