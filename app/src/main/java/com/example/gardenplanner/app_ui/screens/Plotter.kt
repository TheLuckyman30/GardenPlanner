package com.example.gardenplanner.app_ui.screens

import ads_mobile_sdk.cu
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gardenplanner.R
import com.example.gardenplanner.utils.classes.GardenBox
import com.example.gardenplanner.utils.classes.Plant
import com.example.gardenplanner.utils.classes.PlotterPlant
import kotlin.math.roundToInt

//fun autoGen(inBox: Box): Plant{
//    if (inBox.plant.plantType == "Empty"){
//        val ranum = (1..4).random()
//        if(ranum == 1){return(Plant("Tomato",  R.drawable.tomato))}
//        else if(ranum == 2){return Plant("Blueberry",R.drawable.blueberry)}
//        else if(ranum == 3){return Plant("String Beans", R.drawable.string_beans)}
//        else {return Plant("Carrot", R.drawable.carrot)}
//    }
//    return inBox.plant
//}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Plotter(userPlants: List<Plant>) {
    if (userPlants.isNotEmpty()) {
        val allPlants: List<PlotterPlant> = userPlants.map { plant -> PlotterPlant(plant, R.drawable.tomato) }
        var currentPlant by remember { mutableStateOf(allPlants[0]) }
        var gardenBoxes by remember { mutableStateOf(emptyList<GardenBox>()) }
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
                            ) { Text("Size Down") }
                        }
                        Box(
                            Modifier
                                .background(color = Color(0xFFFFFFFF))
                                .width(100.dp)
                                .clickable(onClick = {
                                    gardenBoxes += GardenBox(
                                        0F,
                                        0F + 450,
                                        image = currentPlant.image,
                                        plantName = currentPlant.plant.name,
                                        sizeMod)
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
                }
            }
        ) {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
//                FilledTonalButton(
//                    onClick = {
//                        boxes.forEach { box -> box.plant = autoGen(box) }
//                        boxes.add(
//                            Box(
//                                offsetX,
//                                offsetY,
//                                Plant(
//                                    curPlant.value.plantType,
//                                    curPlant.value.plantImageid
//                                ),
//                                sizeMod = sizeMod
//                            )
//                        )
//                        boxes.removeAt(boxes.lastIndex)
//                    }, colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF2F7564),
//                        contentColor = Color.White
//                    )
//                ) {
//                    Text("Auto Fill")
//                }
                }
                Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {}
            }
            gardenBoxes.forEach { gardenBox ->
                DraggableBox(gardenBox)
            }
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