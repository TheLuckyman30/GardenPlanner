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
import com.example.gardenplanner.app_ui.screens.Dashboard
import com.example.gardenplanner.app_ui.screens.LandingPage
import com.example.gardenplanner.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var currentScreen by remember { mutableStateOf<Screen>(Screen.LandingPage) }

                Scaffold { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            Screen.LandingPage -> LandingPage(navigate = {
                                currentScreen = Screen.Dashboard
                            })
                            Screen.Dashboard -> Dashboard(navigate = {
                                currentScreen = Screen.LandingPage
                            })
                            else -> {}
                        }
                    }
                }
            }
        }
    }
}
