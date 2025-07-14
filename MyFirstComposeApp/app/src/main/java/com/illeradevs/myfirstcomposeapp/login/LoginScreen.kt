package com.illeradevs.myfirstcomposeapp.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola me llamo $name! esto es una prueba",
        modifier = modifier
    )
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4,
)
@Composable
fun ExamplePreview(){
    Example("Preview")
}

@Composable
fun Example(a: String) {
    Text(
        text = "Jose Manuel $a",
    )
}