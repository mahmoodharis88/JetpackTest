package com.example.composeapp.presentation.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.composeapp.presentation.components.EmailTextField
import com.example.composeapp.presentation.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@Composable
fun LoginScreen(
    onNavigateToHomeScreen: (String) -> Unit,
    viewModel: LoginViewModel,
) {
    val query = viewModel.query.value
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
            EmailTextField(
                email = query,
                onEmailChanged = viewModel::onQueryChanged,
                onExecuteSignUp = onNavigateToHomeScreen,
            )
        }
    }
}