package com.example.gardenplanner.app_ui.screens

import ads_mobile_sdk.h5
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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


val h5 = TextStyle(
    fontSize = 24.sp,
    fontWeight = FontWeight.Medium
)

val h6 = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium
)


@Composable
fun GardenTile(emoji: String) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(
                color = CardWhite,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        if (emoji.isNotBlank()) {
            Text(emoji, fontSize = 22.sp)
        }
    }
}

@Composable
fun GardenGrid(
    plants: List<String> = listOf(
        "🥕", "🥕", "🥕",
        "🍅", "", "",
        "🍉", "🍉", ""
    )
) {
    Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(plants.size) { index ->
                GardenTile(plants[index])
            }
        }
    }
}






@Composable
fun Dashboard( navScanner: ()-> Unit, navPlotter: ()-> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MintGreen)
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        // 🌿 Welcome Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(CardWhite, RoundedCornerShape(20.dp))
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Welcome, User!", style = h5, color = TextDark)
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp)
                        .background(
                            color = Color(0xFF9D5D58),
                            shape = RoundedCornerShape(200.dp)
                        )
                        .clickable { navScanner() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Scan Plants",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp
                        )
                    )
                }

            }
        }

        // 🌱 Garden Plot Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(CardWhite, RoundedCornerShape(20.dp))
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Garden Name", style = h6, color = TextDark)

                // Square garden plot
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(200.dp)
                        .background(
                            color = MintGreen,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        // ⬅️ Previous
                        IconButton(onClick = { /* Previous */ }) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Previous",
                                tint = TextDark
                            )
                        }

                        // 🌱 GRID AREA
                        Box(
                            modifier = Modifier
                                .weight(1F)
                                .padding(horizontal = 8.dp)
                        ) {
                            GardenGrid()
                        }

                        // ➡️ Next
                        IconButton(onClick = { /* Next */ }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Next",
                                tint = TextDark
                            )
                        }
                    }
                }

            }

        }


        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(48.dp)
                .background(
                    color = DarkGreen,
                    shape = RoundedCornerShape(200.dp)
                )
                .clickable { navPlotter() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "My Garden Plots",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp
                )
            )
        }



        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(CardWhite, RoundedCornerShape(20.dp))
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text("November 2025", style = h6, color = TextDark)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    listOf("Sun 30", "Mon 1", "Tue 2", "Wed 3", "Thu 4").forEach {
                        Text(it, color = TextDark)
                    }
                }

                Button(
                    onClick = { /* Open Calendar */ },
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MintGreen)
                ) {
                    Text("Calendar", color = TextDark)
                }
            }
        }
    }
}
