package com.example.peaches

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.peaches.screens.Screens

class MainViewModel : ViewModel() {
    private val _currentScreen: MutableState<Screens> = mutableStateOf(Screens.NavBarScreens.Map)
    val currentScreen: MutableState<Screens> = _currentScreen

    //setCurrentScreen is never used in the app???
    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }
}