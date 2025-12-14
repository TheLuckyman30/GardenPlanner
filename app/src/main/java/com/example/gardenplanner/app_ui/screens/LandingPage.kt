package com.example.gardenplanner.app_ui.screens


import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.gardenplanner.R

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
import androidx.compose.foundation.layout.size
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
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(28.dp)
                ) {

                    // Leaf graphic + background shape
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(260.dp)
                            .background(
                                color = Color(0xFF9CC7B9),
                                shape = RoundedCornerShape(130.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.big_leaf),
                            contentDescription = null,
                            modifier = Modifier.size(310.dp)
                        )
                    }

                    // Title text (two lines like mockup)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Welcome to",
                            fontSize = 28.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "GP Planner !",
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    // Buttons
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextButton(
                            onClick = openLogin,
                            modifier = Modifier
                                .width(299.dp)
                                .height(56.dp)
                                .background(
                                    color = Color(0xFF9CC7B9),
                                    shape = RoundedCornerShape(200.dp)
                                )
                        ) {
                            Text(
                                "Login",
                                fontSize = 24.sp,
                                color = Color.Black
                            )
                        }

                        TextButton(
                            onClick = openSignup,
                            modifier = Modifier
                                .width(299.dp)
                                .height(56.dp)
                                .background(
                                    color = Color(0xFF9CC7B9),
                                    shape = RoundedCornerShape(200.dp)
                                )
                        ) {
                            Text(
                                "Sign up",
                                fontSize = 24.sp,
                                color = Color.Black
                            )
                        }
                    }
                }




            }
        }
    }
}
