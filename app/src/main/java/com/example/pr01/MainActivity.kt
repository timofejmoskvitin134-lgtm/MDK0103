package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.ViewModel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ProductViewModel = viewModel()

            LaunchedEffect(Unit) {
                viewModel.fetchproducts()
            }

            LazyColumn {
                items(viewModel.productsList) { product ->
                    Text(text = "${product.title} — rating: ${product.rating}")
                }
            }
        }
    }
}
