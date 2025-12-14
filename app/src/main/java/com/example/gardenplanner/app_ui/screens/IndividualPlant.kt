package com.example.gardenplanner.app_ui.screens

import androidx.compose.material.icons.filled.Download
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.utils.classes.Plant
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.provider.MediaStore
import android.widget.Toast
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.createBitmap


val DarkGreen = Color(0xFF294A42)
val MediumGreen = Color(0xFF2F7564)
val MintGreen = Color(0xFF9CC7B9)
val LightMint = Color(0xFFE6F2EE)
val CardWhite = Color(0xFFF8FBFA)
val TextDark = Color(0xFF294A42)



@Composable

fun InfoChip(
    emoji: String,
    title: String,
    value: String
) {
    Box(
        modifier = Modifier
            .width(110.dp)
            .background(
                color = MintGreen,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(emoji, fontSize = 28.sp)

            Text(
                title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = TextDark
            )

            Text(
                value,
                fontSize = 13.sp,
                color = TextDark,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun InfoCard(title: String, content: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = CardWhite,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Medium, color = TextDark)
            Spacer(modifier = Modifier.height(8.dp))
            Text(content, fontSize = 14.sp, color = TextDark)
        }
    }
}






fun captureScreen(activity: Activity): Bitmap {
    val view = activity.window.decorView.rootView
    val bitmap = createBitmap(view.width, view.height)
    val canvas = Canvas(bitmap)
    view.draw(canvas)
    return bitmap
}

fun saveBitmapToGallery(context: Context, bitmap: Bitmap) {
    val filename = "GardenPlanner_${System.currentTimeMillis()}.png"

    val values = ContentValues().apply {
        put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/GardenPlanner")
        put(MediaStore.Images.Media.IS_PENDING, 1)
    }

    val uri = context.contentResolver.insert(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        values
    )

    uri?.let {
        context.contentResolver.openOutputStream(it)?.use { output ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
        }

        values.clear()
        values.put(MediaStore.Images.Media.IS_PENDING, 0)
        context.contentResolver.update(it, values, null, null)
    }
}


@Composable
fun IndividualInfo(selectedPlant: Plant?) {
    val context = LocalContext.current
    val activity = context as Activity

    if (selectedPlant == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No Plant Selected!")
        }
        return
    }



    Surface(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        color = White
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            //  Curved Header
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)

                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = DarkGreen,

                ),
                contentAlignment = Alignment.BottomCenter
            ){}


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ) {

                // 🌿 Green curved header shape (BACKGROUND)
                Box(
                    modifier = Modifier
                        .width(260.dp)
                        .height(160.dp)
                        .align(Alignment.TopCenter)
                        .background(
                            color = DarkGreen,
                            shape = RoundedCornerShape(
                                bottomStart = 180.dp,
                                bottomEnd = 180.dp
                            )
                        )
                )

                // ⚪ White circle (CENTERED, IN FRONT)
                Box(
                    modifier = Modifier
                        .size(160.dp)
                        .offset(y = (-60).dp) // pushes it into the green shape
                        .background(
                            color = White,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🌱", fontSize = 64.sp)
                }
                IconButton(
                    onClick = {
                        val bitmap = captureScreen(activity)
                        saveBitmapToGallery(context, bitmap)
                    },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 24.dp)
                        .offset(y = 40.dp)
                        .size(44.dp)
                        .background(
                            color = MintGreen,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Download,
                        contentDescription = "Save",
                        tint = TextDark
                    )
                    // TEMP DISABLED Toast.makeText(context, "Saved to Gallery 🌱", Toast.LENGTH_SHORT).show()

                }
            }



            // 📄 Content Section
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y= -10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // Plant name
                Text(
                    text = selectedPlant.name,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextDark,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                // Snapped date
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = MintGreen,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Snapped On: 11/12/25",
                        color = TextDark,
                        fontSize = 14.sp
                    )
                }

                // Info chips
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),

                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    InfoChip("☀️", "Sun", selectedPlant.growingRequirements.sunlightRequirement)
                    InfoChip("💧", "Water", selectedPlant.growingRequirements.waterRequirement)
                    InfoChip("🌾", "Harvest", selectedPlant.growthDetails.growthPeriod)

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .background(
                            color = MintGreen,
                            shape = RoundedCornerShape(
                                topStart = 40.dp,
                                topEnd = 40.dp
                            )
                        )

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp, vertical = 30.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        InfoCard(
                            title = "Description",
                            content = selectedPlant.description

                        )

                        InfoCard(
                            title = "Planting Instructions",
                            content = "Plant in well-drained soil and space appropriately."
                        )
                    }
                }

                // Description

            }
        }
    }

}



