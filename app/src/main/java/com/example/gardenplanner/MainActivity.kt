package com.example.gardenplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.gardenplanner.app_ui.components.Navbar
import com.example.gardenplanner.app_ui.components.Sidebar
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

                Scaffold(
                    topBar = {
                        Navbar (
                            navAll = { currentScreen = Screen.AllInfoPage },
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

                if (sidebarOpen) {
                    Sidebar(closeSidebar = { sidebarOpen = false })
                }
            }
        }
    }
}
