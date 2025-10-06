package com.illeradevs.myfirstcomposeapp.components.animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun MyCrossfade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }

    Column {
        Row(Modifier.padding(top = 32.dp)) {
            Text(
                text = "Home",
                modifier = Modifier.clickable { currentScreen = "Home" }
            )
            Text(
                text = "Detail",
                modifier = Modifier.clickable { currentScreen = "Detail" }
            )
            Text(
                text = "Login",
                modifier = Modifier.clickable { currentScreen = "Login" }
            )
        }

        Crossfade(
            targetState = currentScreen,
        ) { screen ->
            when (screen) {
                "Home" -> HomeScreen(
                    navigateBack = {},
                    navigateToDetail = {_,_ ->},
                )
                "Detail" -> DetailScreen(
                    id = "",
                    navihateToSetting = {},
                )
                "Login" -> LoginScreen(
                    navigateToDetail = {},
                )
            }
        }
    }

}