package com.example.composeapp.di

import androidx.room.Room
import com.example.composeapp.presentation.MyApplication
import com.example.composeapp.cache.EmployeeDao
import com.example.composeapp.cache.database.AppDatabase
import com.example.composeapp.cache.model.EmployeeEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDb(app: MyApplication): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRecipeDao(db: AppDatabase): EmployeeDao {
        return db.employeeDao()
    }

    @Singleton
    @Provides
    fun provideCacheRecipeMapper(): EmployeeEntityMapper {
        return EmployeeEntityMapper()
    }

}