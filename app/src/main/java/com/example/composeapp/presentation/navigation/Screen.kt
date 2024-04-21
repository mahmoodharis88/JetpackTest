package com.example.composeapp.presentation.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("Main")
    object MedicineListScreen : Screen("MedicineList")


    object EmployeeListScreen : Screen("employeeList")
    object EmployeeDetailsScreen : Screen("employeeDetails")
}
