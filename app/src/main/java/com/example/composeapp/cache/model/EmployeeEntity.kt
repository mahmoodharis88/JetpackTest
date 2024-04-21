package com.example.composeapp.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "discountPercentage")
    val discountPercentage: Double,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "stock")
    val stock: Int,
    @ColumnInfo(name = "brand")
    val brand: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,
    @ColumnInfo(name = "images")
    val images: List<String>
)