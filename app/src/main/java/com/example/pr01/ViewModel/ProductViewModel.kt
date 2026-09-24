package com.example.pr01.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.products
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    val productsList = mutableStateListOf<products>()

    fun fetchproducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.retrofitAPI.getproducts()
                productsList.clear()
                productsList.addAll(response.products)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
