package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Navbar(modifier: Modifier,
           navDashboard: () -> Unit,
           navScanner: () -> Unit,
           navIndividual: () -> Unit,
           navAll: () -> Unit,
           navNotifs: () -> Unit,
           navPlot: () -> Unit) {
    FlowRow(modifier) {
        Button(onClick = navDashboard) {
            Text(text = "Dashboard")
        }
        Button(onClick = navScanner) {
            Text(text = "Scanner")
        }
        Button(onClick = navIndividual) {
            Text(text = "Individual Info")
        }
        Button(onClick = navAll) {
            Text(text = "All Info")
        }
        Button(onClick = navNotifs) {
            Text(text = "Notifications")
        }
        Button(onClick = navPlot) {
            Text(text = "Plotting")
        }
    }
}