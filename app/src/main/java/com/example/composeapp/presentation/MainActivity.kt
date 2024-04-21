package com.example.composeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeapp.datastore.SettingsDataStore
import com.example.composeapp.domain.model.AssociatedDrug
import com.example.composeapp.presentation.navigation.Screen
import com.example.composeapp.presentation.ui.details.DetailsScreen
import com.example.composeapp.presentation.ui.home.HomeScreen
import com.example.composeapp.presentation.ui.home.HomeViewModel
import com.example.composeapp.presentation.ui.login.LoginScreen
import com.example.composeapp.presentation.ui.login.LoginViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var settingsDataStore: SettingsDataStore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.LoginScreen.route
            ) {

                composable(route = Screen.LoginScreen.route) { navBackStackEntry ->
                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    val viewModel: LoginViewModel = viewModel(factory = factory)

                    LoginScreen(
                        onNavigateToHomeScreen = navController::navigate,
                        viewModel = viewModel
                    )
                }

                composable(
                    route = Screen.HomeScreen.route + "/{user}",
                    arguments = listOf(navArgument("user") {
                        type = NavType.StringType
                    })
                ) { navBackStackEntry ->
                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    val viewModel: HomeViewModel = viewModel(factory = factory)

                    HomeScreen(
                        user = navBackStackEntry.arguments?.getString("user").orEmpty(),
                        onNavigateToMedicineDetailScreen = navController::navigate,
                        viewModel = viewModel
                    )
                }


                composable(
                    route = Screen.MedicineListScreen.route + "/{medicine}",
                    arguments = listOf(navArgument("medicine") {
                        type = NavType.StringType
                    })


                ) { navBackStackEntry ->
                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    navBackStackEntry.arguments?.getString("medicine").let {
                        val medicine = Gson().fromJson(it, AssociatedDrug::class.java)
                        if (medicine != null) {
                            DetailsScreen(medicine = medicine)
                        }
                    }


                }

            }
        }
    }

}


