package com.illeradevs.myfirstcomposeapp.components

import android.provider.CalendarContract
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.illeradevs.myfirstcomposeapp.R


@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var isChecked by remember { mutableStateOf(true) }
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            thumbContent = {
                Icon(
                    painter = painterResource(id = R.drawable.payaso), contentDescription = "Check"
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                // Bolita
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Cyan,
                // Icono
                checkedIconColor = Color.Green,
                uncheckedIconColor = Color.Magenta,
                disabledUncheckedIconColor = Color.White,
                disabledCheckedIconColor = Color.Black,
                // Borde
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Magenta,
                // Track
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Black,
                disabledCheckedTrackColor = Color.Blue,
                disabledUncheckedTrackColor = Color.Magenta,
            )
        )
    }
}