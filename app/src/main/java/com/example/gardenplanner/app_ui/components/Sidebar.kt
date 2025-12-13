package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
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
fun Sidebar(closeSidebar: () -> Unit,
            navScanner: () -> Unit,
            navNotifications: () -> Unit,
            navAllPlants: () -> Unit,
            navPlotter: () -> Unit,
            navDashboard: () -> Unit) {
    ModalDrawerSheet (
        modifier = Modifier
            .width(150.dp)
    ) {
        IconButton(onClick = closeSidebar ,
            modifier = Modifier
                .padding(10.dp)
                .width(50.22122.dp)
                .height(49.01075.dp)
                .background(color = Color(0xFF9CC7B9), shape = RoundedCornerShape(size = 360.dp))
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Menu", tint = Color.White)
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Box(modifier = Modifier
                .padding(1.dp)
                .width(63.dp)
                .height(58.dp)
                .background(color = Color(0xFF9CC7B9), shape = RoundedCornerShape(size = 360.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "GP",
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF273B4A),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.25.sp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(0xFF9CC7B9),
                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            )
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(top = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(94.dp)
                        .height(33.dp)
                        .background(color = Color(0xFF9D5D58), shape = RoundedCornerShape(200.dp))
                        .clickable { navScanner() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Scan",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )
                }
            }

            NavigationDrawerItem(
                onClick = navNotifications,
                label = { Text("Notifications", style = navItemsStyle()) },
                selected = false
            )
            HorizontalDivider(color = Color(0xFF273B4A))
            NavigationDrawerItem(
                onClick = navAllPlants,
                label = { Text("Plants", style = navItemsStyle()) },
                selected = false
            )
            HorizontalDivider(color = Color(0xFF273B4A))
            NavigationDrawerItem(
                onClick = navPlotter,
                label = { Text("Garden Plots", style = navItemsStyle()) },
                selected = false
            )
            HorizontalDivider(color = Color(0xFF273B4A))
            NavigationDrawerItem(
                onClick = navDashboard,
                label = { Text("Dashboard", style = navItemsStyle()) },
                selected = false
            )
            HorizontalDivider(color = Color(0xFF273B4A))
        }
    }
}

@Composable
fun navItemsStyle() =
    TextStyle(
        fontSize = 15.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF273B4A),
        letterSpacing = 0.15.sp)