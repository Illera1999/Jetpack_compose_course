package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    var user: String by remember { mutableStateOf("Aris") }
    var value: String by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        MyTextField(user = user, onUserChange = { user = it })
        MySecondTextField(user = value, onValueChange = { value = it })
        MyAdvancaTextField(value = value, onValueChange = { value = it })
        MyPasswordTextField(value = value, onValueChange = { value = it })
        Spacer(modifier = Modifier.height(10.dp))
        MyOutlinedTextField(value = value, onValueChange = { value = it })
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


@Composable
fun MyAdvancaTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = {
//        if (it.contains("a")){
        onValueChange(it.replace("a", ""))
//        }else{
//            onValueChange(it)
//        }
    })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden: Boolean by remember { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text(text = "Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        }
    )
}


@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value, onValueChange = onValueChange)


//    BasicTextField(value = value, onValueChange = onValueChange)

}
