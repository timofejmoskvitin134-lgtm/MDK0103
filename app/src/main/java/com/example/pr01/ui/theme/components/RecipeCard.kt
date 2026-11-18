package com.example.pr01.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pr01.R


@Composable
fun RecipeCard(modifier: Modifier = Modifier, difficulty: String?, name: String?){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                text = name.orEmpty(),
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nunito_sans)),
            )

            Text(
                text = difficulty.orEmpty(),
                fontWeight = FontWeight(700),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.nunito_sans))
            )
        }

    }
}

@Preview
@Composable
private fun RecipesCardPrewiev(){
    RecipeCard(modifier = Modifier,
        "Easy",
        "Classic Margherita Pizza")
}

