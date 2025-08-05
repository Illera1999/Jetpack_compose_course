package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    var user: String by remember { mutableStateOf("Aris") }
    var value: String by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        MyTextField(user = user, onUserChange = { user = it })
        MySecondTextField(user = value, onValueChange = { value = it })
//        MyPasswordTextField()
//        MyLoginTextField()
    }
}


@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(value = user, onValueChange = onUserChange, readOnly = user.isEmpty())
}

@Composable
fun MySecondTextField(user: String, onValueChange: (String) -> Unit) {
    TextField(value = user, onValueChange = onValueChange, placeholder = {
        Box(
            Modifier
                .size(40.dp)
                .background(Color.Red)
        )
        Text(text = "Placeholder")
    })
}