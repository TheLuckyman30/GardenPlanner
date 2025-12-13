package com.example.gardenplanner.app_ui.components.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.gardenplanner.utils.classes.Plant

@Composable
fun CameraConfirm(close: () -> Unit,
                  extractedPlant: Plant?,
                  resetExtractedPlant: () -> Unit,
                  setSelectedPlant: () -> Unit,
                  addUserPlant: () -> Unit,
                  navIndividual: () -> Unit) {
    if (extractedPlant != null) {
        CustomPopup(
            popupWidth = 250F,
            popupHeight = 250F,
            bgColor = Color(0xFF9CC7B9),
            onClickOutside = close,
            padding = 5F,
            content = { CameraConfirmContent(
                navIndividual,
                close,
                extractedPlant,
                resetExtractedPlant,
                addUserPlant,
                setSelectedPlant)
            }
        )
    }
}

@Composable
fun CameraConfirmContent(navIndividual: () -> Unit,
                         close: () -> Unit,
                         extractedPlant: Plant,
                         resetExtractedPlant: () -> Unit,
                         addUserPlant: () -> Unit,
                         setSelectedPlant: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Plant Identified!", modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 10.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF273B4A),
                textAlign = TextAlign.Center,
                letterSpacing = 0.17.sp
            )
        )
        Text(extractedPlant.name, modifier = Modifier
            .align(Alignment.Center),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight(800),
                color = Color(0xFF273B4A),
                textAlign = TextAlign.Center,
                letterSpacing = 0.17.sp
            )
        )
        Row(modifier = Modifier.align(Alignment.BottomCenter)) {
            Box(modifier = Modifier
                .weight(1f)
                .height(31.85.dp)
                .background(color = Color.White, shape = RoundedCornerShape(size = 16.85.dp))
                .padding(start = 8.425.dp, top = 8.425.dp, end = 8.425.dp, bottom = 8.425.dp)
                .clickable(onClick = { resetExtractedPlant(); close() }),
                contentAlignment = Alignment.Center
            ) {
                Text("Scan",
                    style = TextStyle(
                        fontSize = 12.64.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF2F7564)
                    )
                )
            }
            Spacer(Modifier.width(10.dp))
            Box(modifier = Modifier
                .weight(1f)
                .height(31.85.dp)
                .background(color = Color(0xFF2F7564), shape = RoundedCornerShape(size = 16.85.dp))
                .padding(start = 8.425.dp, top = 8.425.dp, end = 8.425.dp, bottom = 8.425.dp)
                .clickable(onClick = { addUserPlant(); setSelectedPlant(); resetExtractedPlant(); navIndividual() }),
                contentAlignment = Alignment.Center
            ) {
                Text("See Info",
                    style = TextStyle(
                        fontSize = 12.64.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
        }
    }
}