package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.illeradevs.myfirstcomposeapp.R


@Preview(showBackground = true)
@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.payaso),
        contentDescription = "Imagen",
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 5.dp,
                shape = CircleShape,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Blue,
                        Color.Green
                    )
                )
            ),
        contentScale = ContentScale.FillBounds
    )
}
@Preview(showBackground = true)
@Composable
fun MyNetwoekImage(modifier: Modifier = Modifier) {
    AsyncImage(
        model = "https://android.com/sample_image.jpg",
        contentDescription = null
    )


}
