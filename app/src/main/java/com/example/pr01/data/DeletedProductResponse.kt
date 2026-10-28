package com.example.pr01.data

data class DeletedProductResponse(
    val id: Int,
    val title: String,
    val price: Double,
    val brand: String,
    val isDeleted: Boolean,
    val deletedOn: String
)
