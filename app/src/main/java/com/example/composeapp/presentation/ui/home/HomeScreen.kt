package com.example.composeapp.presentation.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.composeapp.presentation.components.Greetings
import com.example.composeapp.presentation.components.MedicineList
import com.example.composeapp.presentation.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@Composable
fun HomeScreen(
    user: String,
    viewModel: HomeViewModel,
    onNavigateToMedicineDetailScreen: (String) -> Unit,
) {

    val scaffoldState = rememberBottomSheetScaffoldState()


    val medicines = viewModel.medicines.value

    val loading = viewModel.loading.value

    AppTheme(
        displayProgressBar = false,
        scaffoldState = scaffoldState,
        darkTheme = false
    ) {
        Scaffold(
            contentWindowInsets = WindowInsets(bottom = 50, top = 50),
            snackbarHost = {
                scaffoldState.snackbarHostState
            },
        ) {
            Column {
                Greetings(
                    user = user
                )

                MedicineList(
                    loading = loading, medicines = medicines, onNavigateToMedicineDetailScreen
                )
            }
        }
    }
}