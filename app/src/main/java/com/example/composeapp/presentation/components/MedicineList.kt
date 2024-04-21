package com.example.composeapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.domain.model.AssociatedDrug
import com.example.composeapp.presentation.navigation.Screen
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalCoroutinesApi
@Composable
fun MedicineList(
    loading: Boolean,
    medicines: List<AssociatedDrug>,
    onNavigateToMedicineDetailScreen: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(top = 8.dp)
    ) {
        if (loading && medicines.isEmpty()) {
            LoadingRecipeListShimmer(imageHeight = 80.dp)
        } else if (medicines.isEmpty()) {
            NothingHere()
        } else {
            LazyColumn {
                items(
                    items = medicines
                ) {
                    val medicine = Gson().toJson(it)
                    MedicineView(
                        associatedDrug = it,
                        onClick = {
                            val route = Screen.MedicineListScreen.route +"/$medicine"
                            onNavigateToMedicineDetailScreen(route)
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalComposeUiApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MedicineListPreview() {

    MedicineList(loading = false, listOf(
        AssociatedDrug(
            dose = "1",
            name = "Panadol",
            strength = "High"
        ),
        AssociatedDrug(
            dose = "1",
            name = "Panadol",
            strength = "High"
        ),
        AssociatedDrug(
            dose = "1",
            name = "Panadol",
            strength = "High"
        ),
        AssociatedDrug(
            dose = "1",
            name = "Panadol",
            strength = "High"
        )
    ), {})
}