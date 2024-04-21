package com.example.composeapp.di

import com.example.composeapp.interactor.employes.GetMedicines
import com.example.composeapp.network.MedicineService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {


    @ViewModelScoped
    @Provides
    fun provideGetMedicine(
        medicineService: MedicineService
    ): GetMedicines {
        return GetMedicines(
            medicineService = medicineService
        )
    }

}