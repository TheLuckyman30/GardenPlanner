package com.example.gardenplanner.app_ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gardenplanner.app_ui.components.PlantCard
import com.example.gardenplanner.utils.classes.DefaultPlantsAdvice
import com.example.gardenplanner.utils.classes.Plant

@Composable
fun AllInfo(userPlants: List<Plant>) {
    Surface(modifier = Modifier
        .fillMaxSize()
    ) {
        FlowRow (modifier = Modifier
            .fillMaxSize()
        ) {
            PlantCard(DefaultPlantsAdvice[0])
        }
    }
}