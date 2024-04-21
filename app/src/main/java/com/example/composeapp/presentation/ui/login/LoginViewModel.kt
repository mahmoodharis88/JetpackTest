package com.example.composeapp.presentation.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val query = mutableStateOf("")

    fun onQueryChanged(query: String) {
        setQuery(query)
    }


    private fun setQuery(query: String) {
        this.query.value = query
    }
}