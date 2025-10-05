package com.illeradevs.myfirstcomposeapp.components.navigation.examples

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.illeradevs.myfirstcomposeapp.components.MyOutlinedTextField

@Composable
fun LoginScreen(navigateToDetail: () -> Unit) {
    var showView by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text(text = "Login", fontSize = 30.sp)
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
//                navigateToDetail()
                showView = true
            },
        ) {
            Text(text = "Navegar")
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
    }
    if (showView) {
        BackHandler {
            showView = false
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Red),
        )


    }

}