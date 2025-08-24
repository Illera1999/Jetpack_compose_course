package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.illeradevs.myfirstcomposeapp.R
import com.illeradevs.myfirstcomposeapp.components.state.CheckedBoxState


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


@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
//            .background(Color.Yellow),
        contentAlignment = Alignment.Center,
    ) {
        var isChecked by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { isChecked = !isChecked }
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Blue,
                    checkmarkColor = Color.Green,
                    disabledCheckedColor = Color.Yellow,
                    disabledUncheckedColor = Color.Cyan,
                    disabledIndeterminateColor = Color.Magenta,
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Checkbox")
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckedBoxState("1", "Checkbox 1"),
                CheckedBoxState("2", "Checkbox 2")
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(
                checkedBoxState = myState,
            ) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(isChecked = !it.isChecked)
                    } else {
                        it
                    }
                }
            }
        }
    }

}


@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkedBoxState: CheckedBoxState,
    onCheckedChange: (CheckedBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { }
    ) {
        Checkbox(
            checked = checkedBoxState.isChecked,
            onCheckedChange = { onCheckedChange(checkedBoxState) },
            enabled = true,
        )
        Spacer(Modifier.width(20.dp))
        Text(checkedBoxState.label)
    }
}


@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState: ToggleableState by remember { mutableStateOf(ToggleableState.Off) }
    var child1: Boolean by remember { mutableStateOf(true) }
    var child2: Boolean by remember { mutableStateOf(true) }
    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    parentState = when (parentState) {
                        ToggleableState.On -> {
                            child1 = !child1
                            child2 = !child2
                            ToggleableState.Off
                        }

                        ToggleableState.Off -> {
                            child1 = !child1
                            child2 = !child2
                            ToggleableState.On
                        }

                        ToggleableState.Indeterminate -> {
                            child1 = !child1
                            child2 = !child2
                            ToggleableState.Indeterminate
                        }
                    }
                },

                )
            Text(text = "Child 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Checkbox(
                checked = child1,
                onCheckedChange = { child1 = !child1 },
            )
            Text(text = "Child 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Checkbox(
                checked = child2,
                onCheckedChange = { child2 = !child2 },
            )
            Text(text = "Child 2")
        }
    }
}


@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(true) }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(
            modifier = Modifier,
            selected = state,
            onClick = { state = !state },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Yellow,
                disabledUnselectedColor = Color.Cyan,
            )

        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Radio Button")
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName: String by remember { mutableStateOf("") }
    Column(
        modifier = modifier
    ) {
        RadioButtonComponent(name = "Jose", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Patri", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Juan", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Borja", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Salva", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Dexter", selectedName = selectedName) { selectedName = it }

    }
}


@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onItemSelected(name) }
    ) {
        RadioButton(selected = name == selectedName, onClick = { onItemSelected(name) })
        Text(text = name)
    }
}