package com.illeradevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun RetoDos(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxYellow, boxMagenta, boxGreen, boxRed, boxGray, boxBlack) = createRefs()
        val (boxCyan, boxDarkGray, boxBlue) = createRefs()

        // Cajas de en medio
        Box(modifier = Modifier
            .size(75.dp)
            .background(color = Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {}
        Box(modifier = Modifier
            .size(75.dp)
            .background(color = Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxYellow.top)
                end.linkTo(boxYellow.start)
            }) {}
        Box(modifier = Modifier
            .size(75.dp)
            .background(color = Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxYellow.top)
                start.linkTo(boxYellow.end)
            }) {}

        Box(modifier = Modifier
            .size(175.dp)
            .background(color = Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )


        Box(modifier = Modifier
            .size(75.dp)
            .background(color = Color.Gray)
            .constrainAs(boxGray) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            }) {}
        Box(modifier = Modifier
            .size(75.dp)
            .background(color = Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(boxYellow.end)
            }) {}

        // Cajas de externas
        Box(modifier = Modifier
            .size(175.dp)
            .background(color = Color.Cyan)
            .constrainAs(boxCyan) {
                bottom.linkTo(boxMagenta.top)
                end.linkTo(boxMagenta.end)
            })
        Box(modifier = Modifier
            .size(175.dp)
            .background(color = Color.DarkGray)
            .constrainAs(boxDarkGray) {
                bottom.linkTo(boxGreen.top)
                start.linkTo(boxGreen.start)
            })
        Box(modifier = Modifier
            .size(75.dp)
            .background(color = Color.Black)
            .constrainAs(boxBlack) {
                start.linkTo(boxCyan.end)
                end.linkTo(boxDarkGray.start)
                bottom.linkTo(boxCyan.bottom)
                top.linkTo(boxDarkGray.top)
            })

    }
}