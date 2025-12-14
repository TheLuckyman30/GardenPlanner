package com.example.gardenplanner.app_ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.twotone.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.R
import com.example.gardenplanner.utils.classes.GardenBox
import com.example.gardenplanner.utils.classes.Plant
import com.example.gardenplanner.utils.classes.PlotterPlant
import kotlin.math.roundToInt

fun autoGen(gardenBox: GardenBox, allPlants: List<PlotterPlant>): PlotterPlant? {
    if (gardenBox.image == R.drawable.empty) {
        val randInt = (0..allPlants.size - 1).random()
        return allPlants[randInt]
    }
    return null
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Plotter(userPlants: List<Plant>,
            gardenBoxes: List<GardenBox>,
            addBox: (GardenBox) -> Unit,
            setBoxes: (List<GardenBox>) -> Unit,
            resetBoxes: () -> Unit) {
    if (userPlants.isNotEmpty()) {
        val images = listOf(R.drawable.tomato, R.drawable.carrot, R.drawable.blueberry, R.drawable.string_beans)
        val imageMap = mapOf(
            "tomato" to R.drawable.tomato,
            "carrot" to R.drawable.carrot,
            "blueberry" to R.drawable.blueberry,
            "string_beans" to R.drawable.string_beans
        )
        val allPlants: List<PlotterPlant> = userPlants.map { plant ->
            val image = imageMap[plant.type.lowercase()]
            if (image != null) {
                PlotterPlant(plant, image)
            } else {
                val randInt = (0..3).random()
                PlotterPlant(plant, images[randInt])
            }
        }
        var currentPlant by remember { mutableStateOf(allPlants[0]) }
        var sizeMod = 1.0
        var currentIndex = 0

        Scaffold (
            modifier = Modifier.fillMaxSize().background(Color.White),
            bottomBar = {
                Box(modifier = Modifier
                    .background(Color(0xFFFFFFFF))
                    .height(150.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.End) {
                            FilledTonalIconButton(
                                onClick = {
                                    currentIndex--
                                    if (currentIndex < 0) {
                                        currentIndex = allPlants.size - 1
                                    }
                                    currentPlant = allPlants[currentIndex]
                                },
                                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF2F7564), contentColor = Color.White)
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.TwoTone.KeyboardArrowLeft,
                                    contentDescription = "Left Arrow"
                                )
                            }

                            FilledTonalButton(
                                onClick = {
                                    if (sizeMod > 0.5) {
                                        sizeMod = sizeMod - 0.1
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2F7564),
                                    contentColor = Color.White
                                )
                            ) {
                                Text("Size Down")
                            }
                        }
                        Box(
                            Modifier
                                .background(color = Color(0xFFFFFFFF))
                                .width(100.dp)
                                .clickable(onClick = {
                                    addBox(
                                        GardenBox(
                                            0F,
                                            0F + 450,
                                            image = currentPlant.image,
                                            plantName = currentPlant.plant.name,
                                            sizeMod
                                        )
                                    )
                                })
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(currentPlant.plant.name, fontSize = 10.sp)
                                Image(
                                    painter = painterResource(id = currentPlant.image),
                                    contentDescription = "Selector",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Column {
                            FilledTonalIconButton(
                                onClick = {
                                    currentIndex++
                                    if (currentIndex >= allPlants.size) {
                                        currentIndex = 0
                                    }
                                    currentPlant = allPlants[currentIndex]
                                },
                                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF2F7564), contentColor = Color.White)
                            ) { Icon(
                                imageVector = Icons.AutoMirrored.TwoTone.KeyboardArrowRight,
                                contentDescription = "Right Arrow"
                            ) }
                            FilledTonalButton(
                                onClick = {
                                    if (sizeMod < 1.5) {
                                        sizeMod = sizeMod + 0.1
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2F7564),
                                    contentColor = Color.White
                                )
                            ) {
                                Text("Size Up")
                            }
                        }
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                    }
                }
            }
        ) {
            Column(modifier = Modifier.background(Color.White)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FilledTonalButton(
                        onClick = {
                            setBoxes(gardenBoxes.map { gardenBox ->
                                val plotterPlant = autoGen(gardenBox, allPlants)
                                if (plotterPlant != null) {
                                    gardenBox.copy(
                                        plantName = plotterPlant.plant.name,
                                        image = plotterPlant.image
                                    )
                                } else {
                                    gardenBox
                                }
                            })
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2F7564),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Auto Fill")
                    }
                    FilledTonalButton(
                        onClick = {
                            addBox(
                                GardenBox(
                                    0F,
                                    0F + 450,
                                    R.drawable.empty,
                                    "",
                                    sizeMod
                                )
                            )
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2F7564),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Add Empty")
                    }
                    FilledTonalButton(
                        onClick = resetBoxes,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2F7564),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Clear")
                    }
                }
                Box(modifier = Modifier.fillMaxSize().paint(painterResource(R.drawable.soil), contentScale = ContentScale.FillBounds)) {}
            }
            gardenBoxes.forEach { gardenBox ->
                DraggableBox(gardenBox)
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No Garden Plots", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun DraggableBox(gardenBox: GardenBox) {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableFloatStateOf(gardenBox.offsetX) }
        var offsetY by remember { mutableFloatStateOf(gardenBox.offsetY) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(color = Color(0xFFF7FFFC))
                .size((100*gardenBox.sizeMod).dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        ) {
            Column {
                Text(gardenBox.plantName, fontSize = 10.sp)
                Image(
                    painter = painterResource(id = gardenBox.image),
                    contentDescription = "Plant",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}