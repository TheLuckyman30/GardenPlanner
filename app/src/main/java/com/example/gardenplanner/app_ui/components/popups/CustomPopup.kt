package com.example.gardenplanner.app_ui.components.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomPopup(
    popupWidth: Float,
    popupHeight: Float,
    bgColor: Color,
    onClickOutside: () -> Unit,
    content: @Composable () -> Unit,
    padding: Float
) {
    Dialog (onDismissRequest = onClickOutside) {
        Box(
            modifier = Modifier
                .width(popupWidth.dp)
                .height(popupHeight.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(bgColor)
                .padding(padding.dp)
        ) {
            content()
        }
    }
}