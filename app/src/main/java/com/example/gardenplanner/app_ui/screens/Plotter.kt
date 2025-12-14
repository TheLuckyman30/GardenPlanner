package com.example.gardenplanner.app_ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.twotone.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
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
import com.example.gardenplanner.R
import kotlin.math.roundToInt

@Composable
private fun DraggableBox(offX: Float, offy: Float, plant: Plant, sizeMod: Double) {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableFloatStateOf(offX) }
        var offsetY by remember { mutableFloatStateOf(offy) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(color = Color(0xFFF7FFFC))
                .size((100*sizeMod).dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        ){
            Image(
                painter = painterResource(id = plant.plantImageid),
                contentDescription = plant.plantType,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

data class Plant(var plantType: String, var color: Color, var plantImageid: Int)
data class Box(val offsetX: Float, val offsetY: Float, var plant: Plant, val sizeMod: Double)


fun plantCycle(inPlant: Plant): Plant {
    if (inPlant.plantType == "Tomato") {
        return Plant("Blueberry", Color.Blue, R.drawable.blueberry)
    } else if (inPlant.plantType == "Blueberry") {
        return Plant("String Beans", Color.Green, R.drawable.string_beans)
    } else if (inPlant.plantType == "String Beans") {
        return Plant("Carrot", Color(0xFFFF9736), R.drawable.carrot)
    } else if (inPlant.plantType == "Carrot") {
        return  Plant("Empty", Color.Transparent, R.drawable.empty)
    }else return(Plant("Tomato", Color.Red,  R.drawable.tomato))
}

fun plantCycleReverse(inPlant: Plant): Plant {
    if(inPlant.plantType == "Tomato"){
        return Plant("Empty", Color.Transparent, R.drawable.empty)
    }else if(inPlant.plantType == "Blueberry"){
        return (Plant("Tomato", Color.Red,R.drawable.tomato))
    }else if(inPlant.plantType == "String Beans"){
        return Plant("Blueberry", Color.Blue,R.drawable.blueberry)
    } else if (inPlant.plantType == "Carrot") {
        return  Plant("String Beans", Color.Green, R.drawable.string_beans)
    }else return Plant("Carrot", Color(0xFFFF9736), R.drawable.carrot)
}

fun autoGen(inBox: Box): Plant{
    if (inBox.plant.plantType == "Empty"){
        val ranum = (1..4).random()
        if(ranum == 1){return(Plant("Tomato", Color.Red,  R.drawable.tomato))}
        else if(ranum == 2){return Plant("Blueberry", Color.Blue, R.drawable.blueberry)}
        else if(ranum == 3){return Plant("String Beans", Color.Green, R.drawable.string_beans)}
        else {return Plant("Carrot", Color(0xFFFF9736), R.drawable.carrot)}
    }
    return inBox.plant
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Plotter() {
    val curPlant = remember{ mutableStateOf(Plant("Tomato", Color.Red,R.drawable.tomato)) }
    val boxes = remember {
        mutableStateListOf<Box>()
    }
    var plantState by remember { mutableIntStateOf(R.drawable.tomato) }
    var sizeMod = 1.0

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    Scaffold {
        Column {
            BottomAppBar(modifier = Modifier.background(Color(0xFFF7FFFC)).height(150.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.End) {
                        FilledTonalIconButton(
                            onClick = {
                                val tempPlant =
                                    plantCycleReverse(curPlant.value); curPlant.value.plantType =
                                tempPlant.plantType; curPlant.value.color =
                                tempPlant.color; curPlant.value.plantImageid =
                                tempPlant.plantImageid; plantState = tempPlant.plantImageid
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
                            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                            .background(color = Color(0xFFF7FFFC))
                            .size(100.dp)
                            .clickable(onClick = {
                                boxes.add(
                                    element = Box(
                                        offsetX,
                                        offsetY+450,
                                        Plant(
                                            curPlant.value.plantType,
                                            curPlant.value.color,
                                            curPlant.value.plantImageid
                                        ),
                                        sizeMod = sizeMod
                                    )
                                )
                            })
                    ) {
                        Image(
                            painter = painterResource(id = plantState),
                            contentDescription = curPlant.value.plantType,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Column {
                        FilledTonalIconButton(
                            onClick = {
                                val tempPlant =
                                    plantCycle(curPlant.value); curPlant.value.plantType =
                                tempPlant.plantType; curPlant.value.color =
                                tempPlant.color;curPlant.value.plantImageid =
                                tempPlant.plantImageid; plantState = tempPlant.plantImageid
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
                        )
                        { Text("Size Up") }
                    }
                }
            }
                Canvas(
                    Modifier.weight(1f).fillMaxSize().background(Color(0xFF294A42))
                ) {}
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                FilledTonalButton(
                    onClick = {
                        boxes.forEach { box -> box.plant = autoGen(box) }
                        boxes.add(
                            Box(
                                offsetX,
                                offsetY,
                                Plant(
                                    curPlant.value.plantType,
                                    curPlant.value.color,
                                    curPlant.value.plantImageid
                                ),
                                sizeMod = sizeMod
                            )
                        )
                        boxes.removeAt(boxes.lastIndex)
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2F7564),
                        contentColor = Color.White
                    )
                ) { Text("Auto Fill") }
            }
        }
        boxes.forEach { box ->
            DraggableBox(box.offsetX, box.offsetY, box.plant, box.sizeMod)
        }
    }
}