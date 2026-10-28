package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr01.ViewModel.ProductViewModel
import com.example.pr01.ui.theme.Pr01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pr01Theme {
                val productViewModel: ProductViewModel = viewModel()

                LaunchedEffect(Unit) {
                    productViewModel.deleteProduct(id = 12)
                }
            }
        }
    }
}