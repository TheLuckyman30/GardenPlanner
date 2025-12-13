package com.example.gardenplanner.app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LandingPage(innerPadding: PaddingValues,
                openLogin: () -> Unit,
                openSignup: () -> Unit) {
    val gradientColors = listOf(Color(0xFF294A42), Color(0xFF2F7564))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = gradientColors
            )
        )
    ) {
        Surface(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            color = Color.Transparent,
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.5F)
                        .fillMaxWidth()
                        .padding(25.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Welcome to Garden Plot Planner",
                        style = TextStyle(
                            fontSize = 40.sp,
                            lineHeight = 50.sp,
                            fontWeight = FontWeight(400),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.4.sp,
                        )
                    )
                    Column {
                        TextButton (
                            onClick = openLogin,
                            modifier = Modifier
                                .width(299.dp)
                                .background(color = Color(0xFF9CC7B9), shape = RoundedCornerShape(size = 200.dp))
                        ) {
                            Text("Login",
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.3.sp,
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        TextButton (
                            onClick = openSignup,
                            modifier = Modifier
                                .width(299.dp)
                                .background(color = Color(0xFF9CC7B9), shape = RoundedCornerShape(size = 200.dp))
                        ) {
                            Text("Signup",
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.3.sp,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}