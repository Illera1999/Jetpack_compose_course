package com.illeradevs.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.illeradevs.myfirstcomposeapp.R


@Composable
fun MyButton(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = {
                Log.i("Jose", "Botón pulsado")
            },
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black
            )
        ) {
            Text(text = "Botón")
        }

        OutlinedButton(
            onClick = {}, colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black
            )
        ) {
            Text(text = "Botón")
        }


        TextButton(onClick = {}) {
            Text(text = "Botón")
        }


        ElevatedButton(
            onClick = {}, elevation = ButtonDefaults.elevatedButtonElevation(20.dp)
        ) {
            Text(text = "Botón")
        }


        FilledTonalButton(
            onClick = {},
        ) {}

        Button(
            onClick = {},
        ) {}
    }
}


@Preview
@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = CircleShape,
        contentColor = Color.White,
        containerColor = Color.Red,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "Icon",
        )
    }

}