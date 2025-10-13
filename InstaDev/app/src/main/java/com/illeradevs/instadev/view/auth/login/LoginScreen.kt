package com.illeradevs.instadev.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.illeradevs.instadev.R

@Preview
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(Color.White)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español(España)",
                color = Color.Gray
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "InstaDev logo header"
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = email,
                label = {
                    Text(
                        text = "Usuario, correo electrónico o móvil"
                    )
                },
                onValueChange = {
                    email = it
                }
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = password,
                label = {
                    Text(
                        text = "Contraseña"
                    )
                },
                onValueChange = {
                    password = it
                }
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Iniciar sesión"
                )
            }
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "¿Has olvidado la contraseña?"
                )
            }
            Spacer(
                modifier = Modifier.weight(1.3f)
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(
                    text = "Crear cuanta nueva"
                )
            }
            Icon(
                modifier = Modifier
                    .width(80.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Meta logo",
                tint = Color.Gray
            )
        }
    }
}