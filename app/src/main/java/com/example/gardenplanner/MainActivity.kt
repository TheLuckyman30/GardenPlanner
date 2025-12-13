package com.example.gardenplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.gardenplanner.app_ui.components.Navbar
import com.example.gardenplanner.app_ui.components.Sidebar
import com.example.gardenplanner.app_ui.components.popups.CustomPopup
import com.example.gardenplanner.app_ui.components.popups.Login
import com.example.gardenplanner.app_ui.screens.*
import com.example.gardenplanner.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var currentScreen by remember { mutableStateOf<Screen>(Screen.LandingPage) }
                var sidebarOpen by remember { mutableStateOf(false) }
                val list = listOf("1", "2", "3")

                Scaffold(
                    topBar = {
                        Navbar (
                            navAll = { currentScreen = Screen.AllInfoPage },
                            navDashboard = { currentScreen = Screen.Dashboard },
                            navPlot = { currentScreen = Screen.PlotterPage },
                            openSidebar = { sidebarOpen = true }
                        )
                    }
                )
                { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            Screen.LandingPage -> LandingPage()
                            Screen.Dashboard -> Dashboard()
                            Screen.SeedScanner -> Scanner()
                            Screen.IndividualInfoPage -> IndividualInfo()
                            Screen.AllInfoPage -> AllInfo()
                            Screen.NotificationsPage -> Notifications()
                            Screen.PlotterPage -> Plotter()
                        }
                    }
                }
                AnimatedVisibility(
                    visible = sidebarOpen,
                    enter = slideInHorizontally { fullWidth -> -fullWidth },
                    exit = slideOutHorizontally { fullWidth -> -fullWidth * 2 }
                ) {
                    Sidebar(
                        closeSidebar = { sidebarOpen = false },
                        navScanner = { currentScreen = Screen.SeedScanner },
                        navNotifications = { currentScreen = Screen.NotificationsPage },
                        navAllPlants = { currentScreen = Screen.AllInfoPage },
                        navPlotter = { currentScreen = Screen.PlotterPage },
                        navDashboard = { currentScreen = Screen.Dashboard })
                }

                // Pop-Ups
                Login()
            }
        }
    }
}
