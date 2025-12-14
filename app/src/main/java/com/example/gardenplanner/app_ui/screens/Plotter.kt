package com.example.gardenplanner.app_ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
private fun DraggableBox(offX: Float, offy: Float, color: Color) {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableFloatStateOf(offX) }
        var offsetY by remember { mutableFloatStateOf(offy) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(color = Color(0xFFF7FFFC))
                .size(100.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        ){
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(color = color, radius = size.minDimension / 3f)
            }

//            Image(
//                painter = painterResource(id = R.drawable.tomato),
//                contentDescription = "Tomato",
//                modifier = Modifier.fillMaxSize()
//            )
        }
    }
}

data class Plant(var plantType: String, var color: Color)
data class Box(val offsetX: Float, val offsetY: Float, val plant: Plant)

fun plantCycle(inPlant: Plant): Plant {
    if(inPlant.plantType == "Tomato"){
        return Plant("Blueberry", Color.Blue)
    }else if(inPlant.plantType == "Blueberry"){
        return Plant("String Beans", Color.Green)
    }else if(inPlant.plantType == "String Beans"){
        return Plant("Carrot", Color(0xFFFF9736))
    }else return(Plant("Tomato", Color.Red))
}
fun plantCycleReverse(inPlant: Plant): Plant {
    if(inPlant.plantType == "Tomato"){
        return Plant("Carrot", Color(0xFFFF9736))
    }else if(inPlant.plantType == "Blueberry"){
        return (Plant("Tomato", Color.Red))
    }else if(inPlant.plantType == "String Beans"){
        return Plant("Blueberry", Color.Blue)
    }else return Plant("String Beans", Color.Green)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Plotter() {
    val curPlant = remember{ mutableStateOf(Plant("Tomato", Color.Red)) }
    val boxes = remember {
        mutableStateListOf<Box>()
    }
    var colorState by remember { mutableStateOf(Color.Red) }

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    Scaffold {


        BottomAppBar(modifier = Modifier.height(150.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Makes the Row take up the full available width
                    .padding(16.dp), // Adds some padding around the buttons
                horizontalArrangement = Arrangement.SpaceEvenly // Distributes space evenly between buttons
            ) {
                Button(onClick = {
                    val tempPlant = plantCycleReverse(curPlant.value); curPlant.value.plantType =
                    tempPlant.plantType; curPlant.value.color = tempPlant.color; colorState = tempPlant.color
                }) { }

                Box(
                    Modifier
                        .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                        .background(color = Color(0xFFF7FFFC))
                        .size(100.dp)
                        .clickable(onClick = {
                            boxes.add(
                                element = Box(
                                    offsetX,
                                    offsetY,
                                    Plant(curPlant.value.plantType, curPlant.value.color)
                                )
                            )
                        })
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(color = colorState, radius = size.minDimension / 3f)
                    }}
                    Button(onClick = {
                        val tempPlant = plantCycle(curPlant.value); curPlant.value.plantType =
                        tempPlant.plantType; curPlant.value.color = tempPlant.color; colorState = tempPlant.color
                    }) { }

            }
        }
        boxes.forEach { box ->
            DraggableBox(box.offsetX, box.offsetY, box.plant.color)
        }
    }
}