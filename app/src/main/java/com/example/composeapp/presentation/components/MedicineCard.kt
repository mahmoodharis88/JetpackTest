package com.example.composeapp.presentation.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.domain.model.AssociatedDrug

@ExperimentalComposeUiApi
@Composable
fun MedicineView(
    associatedDrug: AssociatedDrug,
    onClick: () -> Unit = {},
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
                start = 9.dp,
                end = 9.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Text(
                    text = "Name : ",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.headlineLarge
                )

                Text(
                    text = associatedDrug.name,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Row {
                Text(
                    text = "Dose : ",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = associatedDrug.dose,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Row {
                Text(
                    text = "Strength : ",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    text = associatedDrug.strength,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}


@ExperimentalComposeUiApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MedicineViewPreview(
    associatedDrug: AssociatedDrug = AssociatedDrug(
        dose = "1",
        name = "Panadol",
        strength = "High"
    ),
    onClick: () -> Unit = {},
) {
    MedicineView(associatedDrug = associatedDrug, onClick = onClick)
}
