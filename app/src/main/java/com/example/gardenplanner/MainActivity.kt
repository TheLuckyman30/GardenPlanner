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
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.app_ui.components.Navbar
import com.example.gardenplanner.app_ui.screens.*
import com.example.gardenplanner.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var currentScreen by remember { mutableStateOf<Screen>(Screen.LandingPage) }

                Scaffold(
                    topBar = {
                        Navbar(
                            modifier = Modifier.padding(top = 16.dp),
                            navDashboard = { currentScreen = Screen.Dashboard },
                            navScanner = { currentScreen = Screen.SeedScanner },
                            navIndividual = { currentScreen = Screen.IndividualInfoPage },
                            navAll = { currentScreen = Screen.AllInfoPage },
                            navNotifs = { currentScreen = Screen.NotificationsPage },
                            navPlot = { currentScreen = Screen.PlotterPage }
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
            }
        }
    }
}
