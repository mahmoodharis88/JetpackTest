package com.example.composeapp.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composeapp.presentation.components.CircularIndeterminateProgressBar
import com.example.composeapp.presentation.components.ConnectivityMonitor
import com.example.composeapp.presentation.components.DefaultSnackbar
import com.example.composeapp.presentation.components.GenericDialog
import com.example.composeapp.presentation.components.GenericDialogInfo
import java.util.Queue

private val LightThemeColors = lightColorScheme(
    primary = Blue600,
    primaryContainer = Blue400,
    onPrimary = Black2,
    secondary = Color.White,
    secondaryContainer = Teal300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Black2,
)

private val DarkThemeColors = darkColorScheme(
    primary = Blue700,
    primaryContainer = Color.White,
    onPrimary = Color.White,
    secondary = Black1,
    secondaryContainer = Black1,
    onSecondary = Color.White,
    error = RedErrorLight,
    background = Color.Black,
    onBackground = Color.White,
    surface = Black1,
    onSurface = Color.White,
)

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun AppTheme(
    darkTheme: Boolean,
    displayProgressBar: Boolean,
    scaffoldState: BottomSheetScaffoldState,
    dialogQueue: Queue<GenericDialogInfo>? = null,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = QuickSandTypography,
        shapes = AppShapes
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = if (!darkTheme) Grey1 else Color.Black)
        ) {
            Column {
                content()
            }
            CircularIndeterminateProgressBar(isDisplayed = displayProgressBar, 0.3f)
            DefaultSnackbar(
                snackbarHostState = scaffoldState.snackbarHostState,
                onDismiss = {
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
            ProcessDialogQueue(
                dialogQueue = dialogQueue,
            )
        }
    }
}


@Composable
fun ProcessDialogQueue(
    dialogQueue: Queue<GenericDialogInfo>?,
) {
    dialogQueue?.peek()?.let { dialogInfo ->
        GenericDialog(
            onDismiss = dialogInfo.onDismiss,
            title = dialogInfo.title,
            description = dialogInfo.description,
            positiveAction = dialogInfo.positiveAction,
            negativeAction = dialogInfo.negativeAction
        )
    }
}