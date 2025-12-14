package com.example.gardenplanner.app_ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.app_ui.components.NotificationCard
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
    newTime.plusDays(newInterval)
    return Notification(plant, newTime, newInterval)
}

@Composable
fun Notifications(userPlants: List<Plant>,
                  userNotifications: List<Notification>,
                  addNotification: (Notification) -> Unit) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.fillMaxWidth(0.8F)) {
            userNotifications.forEach { notification ->
                NotificationCard(notification)
                Spacer(modifier = Modifier.height(10.dp))
            }
            TextButton(onClick = {
                userPlants.forEach { plant ->
                    val existingNotification = userNotifications.firstOrNull(

                    )
                    val newNotification = generateNotification(plant)
                    addNotification(newNotification)
                }
            }) {
                Text("Test")
            }
        }
    }
}