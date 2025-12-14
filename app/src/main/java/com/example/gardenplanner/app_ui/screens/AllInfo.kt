package com.example.gardenplanner.app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.app_ui.components.PlantCard
import com.example.gardenplanner.utils.classes.DefaultPlantsAdvice
import com.example.gardenplanner.utils.classes.Plant




@Composable
fun PlantCardStyled(
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("🌿", fontSize = 32.sp) // emoji placeholder
            }

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
                    text = "${plant.growingRequirements.sunlightRequirement} Sun",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }

            Row() {
                Text("💧", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "${plant.growingRequirements.waterRequirement} oz per ${plant.growingRequirements.waterRequirement} days",
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


@Composable
fun AllInfo(
    userPlants: List<Plant>,
    navIndividual: () -> Unit,
    setSelectedPlant: (Plant) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MintGreen // background like screenshot
    ) {
        Column {

            // Search bar
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(30.dp))
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Search Plants",
                        color = Color.Gray,
                        modifier = Modifier.weight(1f)
                    )
                    Text("🔍")
                }
            }

            // cards container
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = MintGreen,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(16.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    // Default plants
                    items(DefaultPlantsAdvice) { plant ->
                        PlantCardStyled(
                            plant = plant,
                            onClick = {
                                setSelectedPlant(plant)
                                navIndividual()
                            }
                        )
                    }

                    // User plants
                    items(userPlants) { plant ->
                        PlantCardStyled(
                            plant = plant,
                            onClick = {
                                setSelectedPlant(plant)
                                navIndividual()
                            }
                        )
                    }
                }
            }
        }
    }
}
