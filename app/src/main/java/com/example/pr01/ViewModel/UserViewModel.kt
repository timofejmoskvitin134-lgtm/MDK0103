package com.example.pr01.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.Company
import com.example.pr01.service.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    fun uppdUsers(id: Int) {
        viewModelScope.launch {
            try {
                val user = RetrofitClient.usersService.getUser(id)
                Log.d("UserViewModel", "До изменения: ${user.firstName} ${user.lastName} ${user.company?.name} (Должность: ${user.company?.title})")

                val updatedUser = RetrofitClient.usersService.updateUser(
                    id,
                    user.copy(
                        firstName = "Олег",
                        lastName = "Павлов",
                        company = Company(name = "Интел", title = "Менеджер по продажам")
                    )
                )

                Log.d("UserViewModel", "После изменений ${updatedUser.id} -> ${updatedUser.firstName} ${updatedUser.lastName}, ${updatedUser.company?.name} (Должность: ${updatedUser.company?.title})")


            } catch (ex: Exception) {
                Log.e("UserViewModel", "Ошибка: ${ex.message}", ex)
            }
        }
    }
}