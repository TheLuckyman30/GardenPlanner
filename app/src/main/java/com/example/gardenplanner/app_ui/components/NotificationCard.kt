package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.utils.classes.Notification
import java.time.format.DateTimeFormatter

@Composable
fun NotificationCard(notification: Notification) {
    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, h:mm a")
    val formattedDate = notification.nextDate.format(formatter)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = notification.plant.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF1B3B2F)
            )
            Text(
                text = formattedDate,
                fontSize = 14.sp,
                color = Color(0xFF1B3B2F)
            )
            Text(
                text = "💧 Water in ${notification.interval} day(s)",
                fontSize = 14.sp,
                color = Color(0xFF1B3B2F)
            )
        }
    }
}