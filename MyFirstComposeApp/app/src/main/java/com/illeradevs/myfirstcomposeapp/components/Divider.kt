package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Divider")
        HorizontalDivider(
            thickness = 3.dp,
            color = Color.Red,

        )
        Text(text = "Divider")
        Row {
            Text(text = "Divider")
            VerticalDivider(
                thickness = 6.dp,
                color = Color.Green,
            )
            Text(text = "Divider")
        }
    }
}