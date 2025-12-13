package com.example.gardenplanner.app_ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
private fun DraggableBox(color: Color) {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableFloatStateOf(0f) }
        var offsetY by remember { mutableFloatStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(Color.Blue)
                .size(50.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        ){
            Canvas(modifier = Modifier.fillMaxSize()){
                drawCircle(color = color, radius = size.minDimension/3f)
            }
        }
    }
}

data class Plant(val plantType: String, val color: Color)
data class Box(val start: Int,val plant: Plant)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Plotter() {
    val boxes = remember {
        mutableStateListOf<Box>()
    }


    Scaffold {
        BottomAppBar {
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Makes the Row take up the full available width
                    .padding(16.dp), // Adds some padding around the buttons
                horizontalArrangement = Arrangement.SpaceEvenly // Distributes space evenly between buttons
            ) {
                Button(onClick = { boxes.add(Box(start = 0, Plant("test", Color.Red))) }) { }
            }
        }



        boxes.forEach { box ->
            DraggableBox(box.plant.color)
        }

    }
}