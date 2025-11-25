package com.example.gardenplanner.navigation

sealed class Screens {
    data object LandingPage: Screens()
    data object Dashboard: Screens()
    data object SeedScanner: Screens()
    data object IndividualInfoPage: Screens()
    data object AllInfoPage: Screens()
    data object NotificationsPage: Screens()
    data object PlotterPage: Screens()
}