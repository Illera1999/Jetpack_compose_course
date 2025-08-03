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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstrainExampleGuide(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(25.dp)


        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)

                }
        ) { }

    }


}

@Composable
fun ConstraninBarrien(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(modifier = Modifier
            .size(65.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxRed.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 32.dp)
            })


        Box(modifier = Modifier
            .size(70.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                start.linkTo(barrier)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ConstrainChain(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(boxYellow.top)
            })

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(boxRed.bottom)
                bottom.linkTo(boxCyan.top)
            })


        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(boxYellow.bottom)
                bottom.linkTo(parent.bottom)
            })


        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Packed)
    }
}
