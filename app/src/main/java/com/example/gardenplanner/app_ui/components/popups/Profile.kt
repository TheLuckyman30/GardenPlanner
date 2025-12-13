package com.example.gardenplanner.app_ui.components.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(close: () -> Unit,
            navLandingPage: () -> Unit) {
    CustomPopup(
        popupWidth = 203F,
        popupHeight = 217F,
        onClickOutside = close,
        bgColor = Color.White,
        padding = 0F,
        content = { ProfileContent(close, navLandingPage) }
    )
}

@Composable
fun ProfileContent(close: () -> Unit,
                   navLandingPage: () -> Unit) {
    Column {
        Box(modifier = Modifier
            .width(203.dp)
            .height(83.93582.dp)
            .background(
                color = Color(0xFF9CC7B9),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 14.88506.dp, bottomEnd = 14.88506.dp))
            .padding(5.dp),

            ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .width(50.22122.dp)
                        .height(49.01075.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(size = 360.dp))
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "Menu", tint = Color(0xFF2F7564))
                }
                TextButton (
                    onClick = close,
                ) {
                    Text("Close",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 29.77.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF273B4A),
                            letterSpacing = 0.2.sp,
                        )
                    )
                }
            }
        }
        Box(modifier = Modifier
            .padding(5.dp)
        ) {
            Column {
                TextButton (
                    onClick = navLandingPage,
                ) {
                    Text("Logout",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 29.77.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF273B4A),
                            letterSpacing = 0.18.sp,
                        )
                    )
                }
                HorizontalDivider(color = Color(0xFF273B4A))
                TextButton (
                    onClick = {},
                ) {
                    Text("Account Settings",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 29.77.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF273B4A),
                            letterSpacing = 0.18.sp,
                        )
                    )
                }
                HorizontalDivider(color = Color(0xFF273B4A))
            }
        }
    }
}