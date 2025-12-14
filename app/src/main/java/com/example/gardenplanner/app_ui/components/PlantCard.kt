package com.example.gardenplanner.app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.app_ui.screens.DarkGreen
import com.example.gardenplanner.app_ui.screens.MintGreen
import com.example.gardenplanner.utils.classes.Plant

@Composable
fun PlantCard(
    plant: Plant,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = DarkGreen,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(12.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🌿", fontSize = 32.sp) // emoji placeholder
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                // Plant name
                Text(
                    text = plant.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                // Sun
                Row() {
                    Text("☀️", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = plant.growingRequirements.sunlightRequirement,
                        color = Color.White,
                        fontSize = 13.sp
                    )
                }

                Row() {
                    Text("💧", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = plant.growingRequirements.waterRequirement,
                        color = Color.White,
                        fontSize = 13.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .background(color= MintGreen, CircleShape),
                    verticalAlignment = Alignment.CenterVertically


                ) {
                    Text(" Click For More...", color = Color.White, fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("⬇", fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
}