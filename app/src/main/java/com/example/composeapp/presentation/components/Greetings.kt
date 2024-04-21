package com.example.composeapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun Greetings(
    user: String
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Start),
                text = "Welcome $user",
                style = MaterialTheme.typography.headlineSmall
            )
            val currentTime = getCurrentDateTime()
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Start),
                text = "its $currentTime",
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

fun getCurrentDateTime(): String {

    val df: DateFormat = SimpleDateFormat("KK:mm a", Locale.getDefault())
    val currentDateAndTime: String = df.format(Date())

    return currentDateAndTime
}