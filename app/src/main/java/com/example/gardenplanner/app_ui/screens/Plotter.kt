package com.example.gardenplanner.app_ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.gardenplanner.R
import kotlin.math.roundToInt

@Composable
private fun DraggableBox(offX: Float, offy: Float, plant: Plant) {
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
            Image(
                painter = painterResource(id = plant.plantImageid),
                contentDescription = plant.plantType,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

data class Plant(var plantType: String, var color: Color, var plantImageid: Int)
data class Box(val offsetX: Float, val offsetY: Float, val plant: Plant)


fun plantCycle(inPlant: Plant): Plant {
    if(inPlant.plantType == "Tomato"){
        return Plant("Blueberry", Color.Blue, R.drawable.blueberry)
    }else if(inPlant.plantType == "Blueberry"){
        return Plant("String Beans", Color.Green, R.drawable.string_beans)
    }else if(inPlant.plantType == "String Beans"){
        return Plant("Carrot", Color(0xFFFF9736), R.drawable.carrot)
    }else return(Plant("Tomato", Color.Red,  R.drawable.tomato))
}

fun plantCycleReverse(inPlant: Plant): Plant {
    if(inPlant.plantType == "Tomato"){
        return Plant("Carrot", Color(0xFFFF9736), R.drawable.carrot)
    }else if(inPlant.plantType == "Blueberry"){
        return (Plant("Tomato", Color.Red,R.drawable.tomato))
    }else if(inPlant.plantType == "String Beans"){
        return Plant("Blueberry", Color.Blue,R.drawable.blueberry)
    }else return Plant("String Beans", Color.Green, R.drawable.string_beans)
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
                    tempPlant.plantType; curPlant.value.color = tempPlant.color; curPlant.value.plantImageid = tempPlant.plantImageid; plantState = tempPlant.plantImageid
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
                                    Plant(curPlant.value.plantType, curPlant.value.color, curPlant.value.plantImageid)
                                )
                            )
                        })
                ) {
                    Image(
                        painter = painterResource(id = plantState),
                        contentDescription = curPlant.value.plantType,
                        modifier = Modifier.fillMaxSize()
                    )}
                    Button(onClick = {
                        val tempPlant = plantCycle(curPlant.value); curPlant.value.plantType =
                        tempPlant.plantType; curPlant.value.color = tempPlant.color;curPlant.value.plantImageid = tempPlant.plantImageid; plantState = tempPlant.plantImageid
                    }) { }

            }
        }
        boxes.forEach { box ->
            DraggableBox(box.offsetX, box.offsetY, box.plant)
        }
    }
}