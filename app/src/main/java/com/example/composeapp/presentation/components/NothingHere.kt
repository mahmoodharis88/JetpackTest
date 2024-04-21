package com.example.composeapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun NothingHere() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                text = "¯\\_(ツ)_/¯",
                style = TextStyle(fontSize = 55.sp)
            )
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                text = "There's nothing here",
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}