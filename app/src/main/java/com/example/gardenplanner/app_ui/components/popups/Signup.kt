package com.example.gardenplanner.app_ui.components.popups

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Signup(close: () -> Unit,
           navDashboard: () -> Unit) {
    CustomPopup(
        popupWidth = 355F,
        popupHeight = 505F,
        onClickOutside = close,
        bgColor = Color(0xFF9CC7B9),
        content = { SignupContent(navDashboard) })
}

@Composable
fun SignupContent(navDashboard: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Register",
                style = TextStyle(
                    fontSize = 39.05.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        BasicTextField(
            value = username,
            onValueChange = { newUsername ->
                username = newUsername
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(36.8696.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.56821.dp))
                .padding(start = 8.875.dp, top = 8.875.dp, end = 8.875.dp, bottom = 8.875.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (username.isEmpty()) {
                        Text(
                            "Username",
                            fontWeight = FontWeight(500),
                            color = Color(0xFF2F7564)
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        BasicTextField(
            value = email,
            onValueChange = { newEmail ->
                email = newEmail
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(36.8696.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.56821.dp))
                .padding(start = 8.875.dp, top = 8.875.dp, end = 8.875.dp, bottom = 8.875.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (email.isEmpty()) {
                        Text(
                            "Email",
                            fontWeight = FontWeight(500),
                            color = Color(0xFF2F7564)
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        BasicTextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(36.8696.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.56821.dp))
                .padding(start = 8.875.dp, top = 8.875.dp, end = 8.875.dp, bottom = 8.875.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (password.isEmpty()) {
                        Text(
                            "Password",
                            fontWeight = FontWeight(500),
                            color = Color(0xFF2F7564)
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Box(modifier = Modifier
                .width(201.4073.dp)
                .height(50.02273.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 26.32775.dp))
                .padding(start = 13.16388.dp, top = 13.16388.dp, end = 13.16388.dp, bottom = 13.16388.dp)
                .clickable(onClick = navDashboard),
                contentAlignment = Alignment.Center
            ) {
                Text("REGISTER",
                    style = TextStyle(
                        fontSize = 19.75.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF2F7564)
                    )
                )
            }
        }
    }
}