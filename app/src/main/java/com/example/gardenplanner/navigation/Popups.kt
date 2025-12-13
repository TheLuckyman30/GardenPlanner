package com.example.gardenplanner.navigation

sealed class Popup {
    data object Login: Popup()
    data object Signup: Popup()
}