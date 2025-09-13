package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.illeradevs.myfirstcomposeapp.R

@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(
        contentColor = Color.Blue,
        containerColor = Color.Green

    ) {
        Text(text = "5")
    }
}

@Preview
@Composable
fun MyBadgedBox(modifier: Modifier = Modifier) {
    BadgedBox(
        modifier = modifier,
        badge = {
            MyBadge()
        }
    ) {
        Icon(
            painter = painterResource(
                id = R.drawable.ic_shopping_cart
            ),
            contentDescription = "",
        )

    }

}