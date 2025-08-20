package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.illeradevs.myfirstcomposeapp.R


@Preview
@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Green,
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = Modifier.size(20.dp))
        LinearProgressIndicator(
            color = Color.Blue, trackColor = Color.Yellow, strokeCap = StrokeCap.Round
        )
    }

}

@Preview
@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {
    var progress: Float by remember { mutableFloatStateOf(0f) }
    var isLoading by remember { mutableStateOf(false) }
    val animatedProgress: Float by animateFloatAsState(targetValue = progress)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = {
//                0.5f
//                progress
                    animatedProgress
                },
                modifier = Modifier.size(100.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Green,
                strokeCap = StrokeCap.Round
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        LinearProgressIndicator(
            progress = {
//                progress
                animatedProgress
            },
            color = Color.Blue,
            trackColor = Color.Yellow,
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row {
            Button(
                onClick = { progress -= 0.1f }
            ) {
                Text("<-")
            }
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = { progress += 0.1f }
            ) {
                Text("->")
            }
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = { isLoading = !isLoading }) {
                Text(text = "Show/Hide")
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        LottieLoader()
    }

}

@Composable
fun LottieLoader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}