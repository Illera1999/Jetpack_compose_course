package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue: Float by remember { mutableFloatStateOf(0.5f) }
    Column(modifier = modifier.padding(20.dp)) {
        Slider(
            value = myValue, onValueChange = { myValue = it }, colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Yellow,
                inactiveTrackColor = Color.Blue,
                disabledThumbColor = Color.Cyan,
                disabledActiveTrackColor = Color.Magenta,
                disabledInactiveTrackColor = Color.Green,
            )
        )
        Text(myValue.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example: String by remember { mutableStateOf(":(") }
    val state: SliderState = remember {
        SliderState(value = 5f, valueRange = 0f..10f, steps = 9, onValueChangeFinished = {
            example = "Feliz"
        })
    }

    val color: SliderColors = SliderDefaults.colors(
        thumbColor = Color.Red,
        activeTrackColor = Color.Yellow,
        inactiveTrackColor = Color.Blue,
        disabledThumbColor = Color.Cyan,
        disabledActiveTrackColor = Color.Magenta,
        disabledInactiveTrackColor = Color.Green,
    )


    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Slider(
            state = state,
            colors = color,
            thumb = { state: SliderState ->
                Box(
                    Modifier
                        .width(10.dp)
                        .height(30.dp)
                        .background(Color.Red)
                )
            },
            track = { state: SliderState ->
                Box(
                    Modifier
                        .width(100.dp)
                        .height(5.dp)
                        .background(Color.Blue)
                )
            },
        )
        Text(state.value.toString())
        Text(example)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    val color: SliderColors = SliderDefaults.colors(
        thumbColor = Color.Red,
        activeTrackColor = Color.Yellow,
        inactiveTrackColor = Color.Blue,
        disabledThumbColor = Color.Cyan,
        disabledActiveTrackColor = Color.Magenta,
        disabledInactiveTrackColor = Color.Green,
    )
    val state: RangeSliderState = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            steps = 9,
        )
    }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        RangeSlider(
            state = state, colors = color,
            startThumb = {
                Box(
                    Modifier.size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
//                    Text(it.activeRangeStart.toString())
                    Text(String.format("%.1f", it.activeRangeStart))
                }
            },
            endThumb = {
                Box(
                    Modifier.size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
//                    Text(it.activeRangeStart.toString())
                    Text(String.format("%.1f", it.activeRangeStart))
                }
            },
        )
    }

}