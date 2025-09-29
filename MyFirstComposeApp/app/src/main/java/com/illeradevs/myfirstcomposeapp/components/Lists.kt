package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    val names: List<String> = listOf(
        "Jose",
        "Maria",
        "Juan",
        "Luis",
    )

//    LazyColumn(modifier = modifier.fillMaxSize()) {
//        items(names) {
//            Text(
//                text = it,
//                modifier = Modifier.padding(4.dp)
//            )
//        }
//    }
    LazyRow(modifier = modifier.fillMaxSize()) {
        items(names) {
            Text(text = it, modifier = Modifier
                .padding(4.dp)
                .clickable {
                    onItemClick(it)
                }

            )
        }
    }
}