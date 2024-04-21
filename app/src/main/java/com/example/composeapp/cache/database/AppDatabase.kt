package com.example.composeapp.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeapp.cache.EmployeeDao
import com.example.composeapp.cache.model.EmployeeEntity

@Database(entities = [EmployeeEntity::class ], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object{
        val DATABASE_NAME: String = "employee_db"
    }


}