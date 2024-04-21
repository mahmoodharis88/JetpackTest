package com.example.composeapp.network

data class EmployeeResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)