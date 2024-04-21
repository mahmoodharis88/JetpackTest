package com.example.composeapp.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.presentation.navigation.Screen


@ExperimentalComposeUiApi
@Composable
fun EmailTextField(
    email: String,
    onEmailChanged: (String) -> Unit,
    onExecuteSignUp: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,
        tonalElevation = 8.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = email,
                onValueChange = { onEmailChanged(it) },
                label = { Text(text = stringResource(id = R.string.email_or_username)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done,
                ),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
                textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Button(
                modifier = Modifier.padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {
                    if (email.isNotEmpty()) {
                        val route = Screen.HomeScreen.route + "/$email"
                        onExecuteSignUp(route)
                    } else {
                        Toast.makeText(context, "Text cannot empty", Toast.LENGTH_SHORT)
                            .show() // in Activity
                    }

                }
            ) {
                Text(text = stringResource(id = R.string.sign_up))
            }
        }
    }
}


@ExperimentalComposeUiApi
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun EmailTextFieldPreview(
    email: String = "",
    onEmailChanged: (String) -> Unit = {},
    onExecuteSignUp: (String) -> Unit = {},
) {
    EmailTextField(
        email = email,
        onEmailChanged = onEmailChanged,
        onExecuteSignUp = onExecuteSignUp,
    )
}