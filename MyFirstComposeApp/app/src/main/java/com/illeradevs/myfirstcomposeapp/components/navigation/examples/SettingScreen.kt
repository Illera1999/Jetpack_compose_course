package com.illeradevs.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun SettingScreen(settingModel: SettingModel, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Settings: ${settingModel.id}, DarkMode: ${settingModel.darkMode}",
            fontSize = 30.sp
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { navigateBack() },
        ) {
            Text(text = "Volver al inicio")
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
    }
}