package com.example.gardenplanner.app_ui.components.popups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Loading() {
    CustomPopup(
        popupWidth = 250F,
        popupHeight = 250F,
        bgColor = Color(0xFF9CC7B9),
        onClickOutside = {},
        padding = 5F,
        content = { LoadingContent() }
    )
}

@Composable
fun LoadingContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Loading",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight(800),
                    color = Color(0xFF273B4A),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.17.sp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            CircularProgressIndicator(color = Color(0xFF273B4A))
        }

    }
}

