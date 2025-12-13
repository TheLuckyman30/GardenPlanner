package com.example.gardenplanner.app_ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gardenplanner.utils.classes.Plant

@Composable
fun IndividualInfo(selectedPlant: Plant?) {
    if (selectedPlant != null) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Text(selectedPlant.toString())
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Text("No Plant Selected!")
        }
    }
}