package com.example.composeapp.interactor.employes

import com.example.composeapp.domain.data.DataState
import com.example.composeapp.domain.model.Response
import com.example.composeapp.network.MedicineService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMedicines(
    private val medicineService: MedicineService,
) {


    fun getMedicine(): Flow<DataState<Response>> = flow {
        try {
            emit(DataState.loading())

            // just to show loading, cache is fast
            delay(1000)

            // get recipe from network
            val networkRecipe = getMedicineFromNetwork() // dto -> domain
            if (networkRecipe != null) {
                emit(DataState.success(networkRecipe))
            }

        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown Error"))
        }
    }

    private suspend fun getMedicineFromNetwork(): Response {
        return medicineService.getMedicine()
    }

}