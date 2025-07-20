package com.illeradevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun MyRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
        Text(
            text = "Hola 1", modifier = Modifier
                .background(color = Color.Red)
        )
        Text(
            text = "Hola 2", modifier = Modifier
                .background(color = Color.Yellow)
        )
        Text(
            text = "Hola 3", modifier = Modifier
                .background(color = Color.Blue)
        )
        Text(
            text = "Hola 4", modifier = Modifier
                .background(color = Color.White)
        )
    }
}