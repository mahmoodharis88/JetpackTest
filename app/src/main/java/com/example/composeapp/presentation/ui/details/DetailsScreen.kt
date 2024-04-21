package com.example.composeapp.presentation.ui.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.composeapp.domain.model.AssociatedDrug
import com.example.composeapp.presentation.components.MedicineView
import com.example.composeapp.presentation.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@Composable
fun DetailsScreen(
    medicine : AssociatedDrug
) {

    val scaffoldState = rememberBottomSheetScaffoldState()

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
            MedicineView(
                associatedDrug = AssociatedDrug(
                    dose = medicine.dose,
                    name = medicine.name,
                    strength = medicine.strength
                ),
                onClick = {}
            )
        }
    }
}