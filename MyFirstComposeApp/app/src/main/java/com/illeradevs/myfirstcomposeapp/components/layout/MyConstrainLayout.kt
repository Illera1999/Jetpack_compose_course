package com.illeradevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun MyBasicConstrainLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxYellow) = createRefs()
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(parent.end)
                }
        ) {}
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.start)
                }
        ) {
            Text(text = "Hola")
        }
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {}
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(parent.start)
                }
        ) {}
    }

}