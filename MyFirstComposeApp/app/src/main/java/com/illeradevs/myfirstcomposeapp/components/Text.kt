package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun MyText(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Pepe")
        Text(text = "Pepe rojo", color = Color.Red)
        Text(text = "Pepe", fontSize = 25.sp)
        Text(text = "FontStyle", fontStyle = FontStyle.Italic)
        Text(text = "FontWeight", fontWeight = FontWeight.Bold)
        Text(text = "LetterSpacing", letterSpacing = 10.sp)
        Text(text = "LetterDecoration", textDecoration = TextDecoration.LineThrough)
        Text(
            text = "LetterDecoration",
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline
        )
        Text(
            text = "Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1

        )
    }
}