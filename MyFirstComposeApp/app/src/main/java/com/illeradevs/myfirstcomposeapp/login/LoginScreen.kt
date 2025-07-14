package com.illeradevs.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola me llamo $name! esto es una prueba",
        modifier = modifier
    )
}


@Preview
@Composable
fun ExamplePreview(){
    Example("Preview")
}

@Composable
fun Example(a: String) {
    Text(
        text = "Jose Manuel $a",
        modifier = Modifier
            .background(color = Color.White)
            .padding(all = 30.dp)
    )
}