package com.illeradevs.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.illeradevs.myfirstcomposeapp.R


//@Preview(showBackground = true)
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
fun MyNetworkImage(modifier: Modifier = Modifier) {
//    Text(text = "Hello World")
    AsyncImage(
        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpXVP82IZLUyJ0rLdq-Vg3CkE2jskDoaZeSw&s",
        contentDescription = null,
        modifier = Modifier.size(500.dp),
        onError = { state ->
            Log.i("Jose Error", "Coil Fallo", state.result.throwable)
        }
    )
}


@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.se_enviea),
        contentDescription = null,
        modifier = modifier.size(50.dp),
        tint = Color.Red
    )


}