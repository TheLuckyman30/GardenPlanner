package com.example.gardenplanner.app_ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Sidebar(
    modifier: Modifier = Modifier
        .fillMaxHeight()
        .width(240.dp),
    navDashboard: () -> Unit,
    navScanner: () -> Unit,
    navIndividual: () -> Unit,
    navAll: () -> Unit,
    navNotifs: () -> Unit,
    navPlot: () -> Unit
) {
    Surface(
        modifier = modifier,
        color = Color(0xFFA7CFC4), // soft mint green
        shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            /* --- TOP ICONS --- */
            IconCircle(icon = Icons.Default.Menu, onClick = { /* maybe open/close */ })
            Spacer(Modifier.height(12.dp))
            IconCircleText("GP") // your GP circle from screenshot

            Spacer(Modifier.height(24.dp))

            /* --- SCAN BUTTON --- */
            Button(
                onClick = navScanner,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB06C61) // salmon-brown button
                ),
                shape = RoundedCornerShape(30)
            ) {
                Text("Scan")
            }

            Spacer(Modifier.height(20.dp))

            /* --- MENU ITEMS --- */
            SidebarItem("Notifications", badgeCount = 5, onClick = navNotifs)
            SidebarItem("Plants", onClick = navAll)
            SidebarItem("Garden Plots", onClick = navPlot)
            SidebarItem("Dashboard", onClick = navDashboard)
            SidebarItem("Calendar", onClick = navIndividual)

            Spacer(modifier = Modifier.weight(1f))

            /* --- BOTTOM SETTINGS --- */
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = Color(0xFF2F3A3A),
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

/* --- Sidebar item with underline --- */
@Composable
fun SidebarItem(text: String, badgeCount: Int? = null, onClick: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClick() },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text, color = Color(0xFF2F3A3A))

            if (badgeCount != null) {
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    tonalElevation = 2.dp,
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(
                        badgeCount.toString(),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        color = Color(0xFF2F3A3A)
                    )
                }
            }
        }

        Divider(color = Color(0xFF46605E), thickness = 1.dp)
    }
}

/* --- Circle icon --- */
@Composable
fun IconCircle(icon: ImageVector, onClick: () -> Unit) {
    Surface(
        shape = CircleShape,
        color = Color(0xFFA7CFC4),
        tonalElevation = 3.dp,
        modifier = Modifier.size(48.dp)
    ) {
        IconButton(onClick = onClick) {
            Icon(icon, contentDescription = null, tint = Color.White)
        }
    }
}

/* --- Circle with text (GP) --- */
@Composable
fun IconCircleText(text: String) {
    Surface(
        shape = CircleShape,
        color = Color.White,
        tonalElevation = 3.dp,
        modifier = Modifier.size(70.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text, color = Color(0xFF2F3A3A))
        }
    }
}
