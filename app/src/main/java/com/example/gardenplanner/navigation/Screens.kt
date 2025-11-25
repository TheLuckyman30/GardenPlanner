package com.example.gardenplanner.navigation

sealed class Screen {
    data object LandingPage: Screen()
    data object Dashboard: Screen()
    data object SeedScanner: Screen()
    data object IndividualInfoPage: Screen()
    data object AllInfoPage: Screen()
    data object NotificationsPage: Screen()
    data object PlotterPage: Screen()
}