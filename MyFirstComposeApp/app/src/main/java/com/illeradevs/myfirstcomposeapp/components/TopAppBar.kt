package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.illeradevs.myfirstcomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(text = "My App")
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Icon",
            )
        },
        actions = {

            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Icon",
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Icon",
                tint = Color.Green
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(

            containerColor = Color.Red,
            titleContentColor = Color.Green,
            navigationIconContentColor = Color.Blue,
            actionIconContentColor = Color.Yellow,
            scrolledContainerColor = Color.Magenta,
        )
    )
}