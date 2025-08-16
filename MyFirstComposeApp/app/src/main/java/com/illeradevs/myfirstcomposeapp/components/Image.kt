package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
       modifier = Modifier.height(200.dp).width(100.dp),
       contentScale = ContentScale.FillWidth


   )
}