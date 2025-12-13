package com.example.gardenplanner.navigation

sealed class Popup {
    data object Login: Popup()
    data object Signup: Popup()
    data object Profile: Popup()
    data object CameraConfirm: Popup()
    data object Loading: Popup()
}