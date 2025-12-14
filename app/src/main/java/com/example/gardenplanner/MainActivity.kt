package com.example.gardenplanner

import android.os.Bundle
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
import com.example.gardenplanner.app_ui.components.popups.CameraConfirm
import com.example.gardenplanner.app_ui.components.popups.CreateNotification
import com.example.gardenplanner.app_ui.components.popups.Loading
import com.example.gardenplanner.app_ui.components.popups.Login
import com.example.gardenplanner.app_ui.components.popups.Profile
import com.example.gardenplanner.app_ui.components.popups.Signup
import com.example.gardenplanner.app_ui.screens.*
import com.example.gardenplanner.navigation.Popup
import com.example.gardenplanner.navigation.Screen
import com.example.gardenplanner.utils.classes.DefaultPlantsAdvice
import com.example.gardenplanner.utils.classes.GardenAdiveViewModel
import com.example.gardenplanner.utils.classes.GardenBox
import com.example.gardenplanner.utils.classes.Notification
import com.example.gardenplanner.utils.classes.Plant
import com.example.gardenplanner.utils.classes.availablePlants
import kotlin.collections.emptyList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                // State Variables

                // Plant
                val adviceState = GardenAdiveViewModel()
                var recognizedText by remember { mutableStateOf("") }
                var extractedPlant by remember { mutableStateOf<Plant?>(null) }
                var userPlants by remember { mutableStateOf(emptyList<Plant>()) }
                var selectedPlant by remember { mutableStateOf<Plant?>(null) }

                //Notifications
                var userNotifications by remember { mutableStateOf(emptyList<Notification>()) }

                // Plotter
                var gardenBoxes by remember { mutableStateOf(emptyList<GardenBox>()) }

                // Navigation
                var currentScreen by remember { mutableStateOf<Screen>(Screen.LandingPage) }
                var currentPopup by remember { mutableStateOf<Popup?>(null) }
                var sidebarOpen by remember { mutableStateOf(false) }

                ////////////////////////////////////////////////////////////////////////////////////

                // Main App
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
                            Screen.Dashboard -> Dashboard(
                                navScanner = {currentScreen= Screen.SeedScanner},
                                navPlotter = {currentScreen= Screen.PlotterPage}

                            )
                            Screen.SeedScanner -> Scanner(

                                updateText = { newText -> recognizedText = newText },
                                setLoading = { currentPopup = Popup.Loading },
                                closeLoading = { currentPopup = Popup.CameraConfirm }
                            )
                            Screen.IndividualInfoPage -> IndividualInfo(selectedPlant)
                            Screen.AllInfoPage -> AllInfo(
                                userPlants,
                                navIndividual = { currentScreen = Screen.IndividualInfoPage },
                                setSelectedPlant = { newPlant -> selectedPlant = newPlant }
                            )
                            Screen.NotificationsPage -> Notifications(
                                userPlants,
                                userNotifications,
                                addNotification = { newNotification -> userNotifications += newNotification },
                                removeNotification = { notification -> userNotifications -= notification },
                                openForm = { currentPopup = Popup.CreateNotification }
                            )
                            Screen.PlotterPage -> Plotter(
                                userPlants,
                                gardenBoxes,
                                addBox = { newBox -> gardenBoxes += newBox },
                                setBoxes = { newBoxes -> gardenBoxes = newBoxes},
                                resetBoxes = { gardenBoxes = emptyList() }
                            )
                        }
                    }
                }

                ////////////////////////////////////////////////////////////////////////////////////

                // Sidebar
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
                    Popup.CameraConfirm -> CameraConfirm(
                        close = { currentPopup = null },
                        extractedPlant,
                        resetExtractedPlant = { extractedPlant = null },
                        setSelectedPlant = { selectedPlant = extractedPlant },
                        addUserPlant = { userPlants += extractedPlant as Plant },
                        navIndividual = { currentScreen = Screen.IndividualInfoPage }
                    )
                    Popup.Loading -> Loading()
                    Popup.CreateNotification -> CreateNotification(
                        close = { currentPopup = null },
                        addNotification = { newNotification -> userNotifications += newNotification }
                    )
                }

                // Effects (Similar to useEffect if you used React before)
                LaunchedEffect(recognizedText) {
                    if (recognizedText != "") {
                        val text = recognizedText.split("\n")
                        val plant = availablePlants.firstOrNull { plant ->
                            text.any { t -> t.lowercase().trim() == plant.lowercase() }
                        }
                        if (plant != null) {
                            adviceState.fetchGardenAdvice(
                                q= plant,
                                setPopup = { newPopup -> currentPopup = newPopup },
                                setPlant = { newPlant -> extractedPlant = newPlant }
                            )
                        } else {
                            currentPopup = Popup.CameraConfirm
                        }
                    }
                }
            }
        }
    }
}
