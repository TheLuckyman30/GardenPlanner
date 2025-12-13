package com.example.gardenplanner.app_ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.gardenplanner.utils.classes.Plants

@Composable
fun AllInfo(userPlants: List<Plants>) {
    Column {
        userPlants.forEach { plant ->
            Text(text = plant.name)
            Text(text = plant.harvestTime.toString())
            Text(text = plant.wateringInterval.toString())
            Text(text = plant.summary)
        }
    }
}