package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
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
fun Navbar(navAll: () -> Unit,
           navDashboard: () -> Unit,
           navPlot: () -> Unit,
           openSidebar: () -> Unit) {
    FlowRow(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFF294A42))
        .height(86.dp).absolutePadding(top = 26.dp),

    ) {
        Box (modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
            contentAlignment = Alignment.Center) {
            Row {
                IconButton(onClick = openSidebar ,
                    modifier = Modifier
                        .absolutePadding(right = 10.dp)
                        .width(50.22122.dp)
                        .height(49.01075.dp)
                        .background(color = Color(0xFF9CC7B9), shape = RoundedCornerShape(size = 360.dp))
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }
                Row(modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(size = 221.48759.dp))) {
                    TextButton(onClick = navAll) {
                        Text("Plants", style = textStyle())
                    }
                    TextButton(onClick = navDashboard) {
                        Text("Home", style = textStyle())
                    }
                    TextButton (onClick = navPlot) {
                        Text("Garden", style = textStyle())
                    }
                }
                IconButton(onClick = {},
                    modifier = Modifier
                        .absolutePadding(left = 10.dp)
                        .width(50.22122.dp)
                        .height(49.01075.dp)
                        .background(color = Color(0xFF9CC7B9), shape = RoundedCornerShape(size = 360.dp))
                ) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu", tint = Color.White)
                }
            }

        }
    }
}

@Composable
fun textStyle() = TextStyle(
    fontSize = 14.sp,
    lineHeight = 22.15.sp,
    fontWeight = FontWeight(400),
    color = Color(0xFF273B4A),
    textAlign = TextAlign.Center,
    letterSpacing = 0.17.sp
)