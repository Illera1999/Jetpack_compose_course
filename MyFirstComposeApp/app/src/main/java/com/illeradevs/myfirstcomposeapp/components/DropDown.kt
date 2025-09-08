package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.illeradevs.myfirstcomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    var selection: String by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(text = "Idioma")
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = 16.dp, y = 10.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = false,
                dismissOnBackPress = false,
                clippingEnabled = false
            )
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "Español")
                },
                onClick = {
                    expanded = false
                    selection = "Español"
                },
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Inglés")
                },
                onClick = {
                    expanded = false
                    selection = "Inglés"
                },
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Francés")
                },
                onClick = {
                    expanded = false
                    selection = "Francés"
                },
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Italiano")
                },
                onClick = {
                    expanded = false
                    selection = "Italiano"
                },
            )
        }
    }
}


@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    Box(modifier = modifier.padding(all = 20.dp)) {
        Button(onClick = { expanded = !expanded }) {
            Text(text = "Ver opciones")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = 16.dp, y = 10.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = false,
                dismissOnBackPress = false,
                clippingEnabled = false
            )
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "Text 1")
                },
                onClick = {
                    expanded = false
                },
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Text 2")
                },
                onClick = {
                    expanded = false
                },
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Text 3")
                },
                onClick = {
                    expanded = false
                },
            )
            DropdownMenuItem(
                text = {
                    Text(text = "Text 4")
                },
                onClick = {
                    expanded = false
                },
            )
        }
    }
}


@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = { Text(text = "Text") },
            onClick = {

            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Icon",
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Icon",
                )
            },
            enabled = true,
            contentPadding = PaddingValues(start = 16.dp),
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Green,
                trailingIconColor = Color.Blue,
                disabledTextColor = Color.Cyan,
                disabledLeadingIconColor = Color.Magenta,
                disabledTrailingIconColor = Color.Yellow,
            )

        )
    }

}