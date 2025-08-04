package com.illeradevs.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun MyState(modifier: Modifier = Modifier) {
    var number = remember{ mutableStateOf(0)}
    Text(text = "Púlsame: ${number.value}", modifier = modifier.clickable { number.value += 1 })
}