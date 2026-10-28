package com.example.pr01.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {

    fun fetchproducts() { /* ... */ }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.retrofitAPI.deleteProduct(id)

                Log.d(
                    "ProductViewModel",
                    "ТОВАР УСПЕШНО УДАЛЕН!" +
                            "\nИдентификатор: ${response.id}" +
                            "\nНазвание: ${response.title}" +
                            "\nisDeleted: ${response.isDeleted}" +
                            "\ndeletedOn: ${response.deletedOn}"
                )
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Ошибка удаления товара: ${e.message}", e)
            }
        }
    }
}
