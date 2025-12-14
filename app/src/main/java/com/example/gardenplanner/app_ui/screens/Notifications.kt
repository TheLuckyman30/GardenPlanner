package com.example.gardenplanner.app_ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.app_ui.components.NotificationCard
import com.example.gardenplanner.app_ui.components.NotificationNav
import com.example.gardenplanner.utils.classes.Notification
import com.example.gardenplanner.utils.classes.Plant

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Notifications(userPlants: List<Plant>,
                  userNotifications: List<Notification>,
                  addNotification: (Notification) -> Unit) {
    Scaffold(
        topBar = { NotificationNav(
            userPlants,
            userNotifications,
            addNotification
        ) }
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .background(Color(0xFF9CC7B9), RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .verticalScroll(rememberScrollState()),
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                contentAlignment = Alignment.Center) {
                Column(Modifier.fillMaxWidth(0.9F)) {
                    userNotifications.forEach { notification ->
                        NotificationCard(notification)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}