package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.utils.classes.Notification
import com.example.gardenplanner.utils.classes.Plant
import java.time.ZonedDateTime

fun generateNotification(plant: Plant): Notification {
    var newInterval: Long = 6
    if (plant.growingRequirements.waterRequirement.lowercase().contains("high")) {
        newInterval = 1
    } else if (plant.growingRequirements.waterRequirement.lowercase().contains("moderate")) {
        newInterval = 3
    }
    val newTime = ZonedDateTime.now()
    val addedTime = newTime.plusDays(newInterval)
    return Notification(plant, addedTime, newInterval)
}

@Composable
fun NotificationNav(userPlants: List<Plant>,
                    userNotifications: List<Notification>,
                    addNotification: (Notification) -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
        contentAlignment = Alignment.Center) {
        Card (
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF735542)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Row {
                TextButton(onClick = {
                    userPlants.forEach { plant ->
                        val existingNotification = userNotifications.firstOrNull { notification ->
                            notification.plant == plant
                        }
                        if (existingNotification == null) {
                            val newNotification = generateNotification(plant)
                            addNotification(newNotification)
                        }
                    }
                }) {
                    Text("Generate",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }
        }
    }
}