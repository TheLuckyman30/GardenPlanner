package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.utils.classes.Notification

@Composable
fun NotificationCard(notification: Notification) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(color = Color(0xFF9CC7B9), RoundedCornerShape(100 .dp))
    ) {

    }
}