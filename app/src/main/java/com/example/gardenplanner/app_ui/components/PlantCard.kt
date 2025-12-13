package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.utils.classes.Plant

@Composable
fun PlantCard(plant: Plant,
              navIndividual: () -> Unit,
              setSelectedPlant: (Plant) -> Unit) {
    Surface(modifier = Modifier
        .width(132.dp)
        .height(149.dp)
        .clickable(onClick = { setSelectedPlant(plant); navIndividual() }),
        shape = RoundedCornerShape(30.dp),
        color = Color(0xFF669B89)
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
            Text(plant.name, style = cardTextStyle())
            Text(plant.sunlight, style = cardTextStyle())
            Text(plant.wateringInterval.toString(), style = cardTextStyle())
        }
    }
}

@Composable
fun cardTextStyle() = TextStyle(
    fontSize = 14.sp,
    lineHeight = 20.sp,
    fontWeight = FontWeight(400),
    color = Color(0xFF241919),
    letterSpacing = 0.12.sp,
)