package com.example.composeapp.domain.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("discountPercentage")
    val discountPercentage: Double,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("images")
    val images: List<String>
)
