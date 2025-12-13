package com.example.gardenplanner

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.app_ui.components.Navbar
import com.example.gardenplanner.app_ui.components.Sidebar
import com.example.gardenplanner.app_ui.components.popups.Login
import com.example.gardenplanner.app_ui.components.popups.Profile
import com.example.gardenplanner.app_ui.components.popups.Signup
import com.example.gardenplanner.app_ui.screens.*
import com.example.gardenplanner.navigation.Popup
import com.example.gardenplanner.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var recognizedText by remember { mutableStateOf("Recognized text will appear here.") }
                var currentScreen by remember { mutableStateOf<Screen>(Screen.LandingPage) }
                var currentPopup by remember { mutableStateOf<Popup?>(null) }
                var sidebarOpen by remember { mutableStateOf(false) }

                Scaffold(
                    topBar = {
                        if (currentScreen != Screen.LandingPage) {
                            Navbar (
                                navAll = { currentScreen = Screen.AllInfoPage },
                                navDashboard = { currentScreen = Screen.Dashboard },
                                navPlot = { currentScreen = Screen.PlotterPage },
                                openSidebar = { sidebarOpen = true },
                                openProfile = { currentPopup = Popup.Profile }
                            )
                        }
                    }
                )
                { innerPadding ->
                    Surface(modifier = Modifier.padding(
                        if( currentScreen == Screen.LandingPage)
                            PaddingValues(0.dp)
                        else innerPadding)
                    ) {
                        when (currentScreen) {
                            Screen.LandingPage -> LandingPage(
                                innerPadding = innerPadding,
                                openLogin = { currentPopup = Popup.Login },
                                openSignup = { currentPopup = Popup.Signup }
                            )
                            Screen.Dashboard -> Dashboard()
                            Screen.SeedScanner -> Scanner(
                                recognizedText,
                                updateText = { newText -> recognizedText = newText }
                            )
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
                when(currentPopup) {
                    null -> null
                    Popup.Login -> Login(
                        close = { currentPopup = null },
                        navDashboard = { currentScreen = Screen.Dashboard; currentPopup = null },
                        openSignUp = { currentPopup = Popup.Signup }
                    )
                    Popup.Signup -> Signup(
                        close = { currentPopup = null },
                        navDashboard = { currentScreen = Screen.Dashboard; currentPopup = null }
                    )
                    Popup.Profile -> Profile(
                        close = { currentPopup = null },
                        navLandingPage = { currentScreen = Screen.LandingPage; currentPopup = null }
                    )
                }

                LaunchedEffect(recognizedText) {
                    Log.d("Test", "Text: ${recognizedText.split("\n")}")
                }
            }
        }
    }
}
