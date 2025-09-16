package com.illeradevs.myfirstcomposeapp.components.advance

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun InteractionSourceExample(modifier: Modifier = Modifier) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val isPressed: Boolean by interactionSource.collectIsPressedAsState()
    Box(
        modifier = modifier
            .size(150.dp)
//            .background(
//                if (isPressed) Color.Red else Color.Green,
//            )
            .background(Color.White)
            .shadow(if (isPressed) 10.dp else 0.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current
            ) {},
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(
                onClick = {},
                interactionSource = interactionSource,
            ) {

                Text(text = "Click me")
            }
            Text(text = if (isPressed) "Pressed" else "Not Pressed")
        }
    }


}