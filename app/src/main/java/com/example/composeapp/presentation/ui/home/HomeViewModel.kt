package com.example.composeapp.presentation.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.domain.model.AssociatedDrug
import com.example.composeapp.domain.model.Response
import com.example.composeapp.interactor.employes.GetMedicines
import com.example.composeapp.presentation.util.ConnectivityManager
import com.example.composeapp.presentation.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val getMedicines: GetMedicines,
) : ViewModel() {

    val loading = mutableStateOf(false)
    val medicines: MutableState<List<AssociatedDrug>> = mutableStateOf(ArrayList())

init {
    getMedicineData()
}
    private fun getMedicineData() {
        medicines.value = emptyList()
        getMedicines.getMedicine().onEach { dataState ->
            loading.value = dataState.loading

            dataState.data?.let { response ->

                medicines.value = parseResponse(response)
            }

            dataState.error?.let { error ->
                Log.e(TAG, "newSearch: $error")
            }
        }.launchIn(viewModelScope)
    }

    private fun parseResponse(response:Response): List<AssociatedDrug> {
        val list: MutableList<AssociatedDrug> = mutableListOf()
        for(problem in response.problems){
            for (diabete in problem.diabetes){
                for (medication in diabete.medications){
                    for (medicationsClasses in medication.medicationsClasses){
                        for (medicationsClasse in medication.medicationsClasses){
                            for(className in medicationsClasse.className){
                                for(associatedDrug in className.associatedDrug){
                                    list.add(associatedDrug)
                                }
                                for(associatedDrug2 in className.associatedDrug2){
                                    list.add(associatedDrug2)
                                }
                            }

                            for(className2 in medicationsClasse.className2){
                                for(associatedDrug in className2.associatedDrug){
                                    list.add(associatedDrug)
                                }
                                for(associatedDrug2 in className2.associatedDrug2){
                                    list.add(associatedDrug2)
                                }
                            }
                        }
                    }
                }
            }
        }
        return list
    }
}