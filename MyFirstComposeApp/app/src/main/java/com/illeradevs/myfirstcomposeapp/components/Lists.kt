package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

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


@Composable
fun MyAdvanseList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    var items by remember { mutableStateOf(List<String>(size = 100) { "Item $it" }) }

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            Button({
                items = items.toMutableList().apply {
                    add(
                        index = 0,
                        element = "Item ${items.size}",
                    )
                }
            }) {
                Text(text = "Add")
            }
        }
        itemsIndexed(items, key = { _, item -> item }) { index, item ->
            Row {
                Text(text = item + " indice:$index", modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onItemClick(item)
                    })
                Spacer(modifier = Modifier.weight(1f))
                TextButton({
                    items = items.toMutableList().apply {
                        remove(item)
//                        removeAt(index)
                    }
                }) {
                    Text(text = "Remove")
                }
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }


}


@Composable
fun ScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 5
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
        ) {
            items(30) {
                Text(
                    text = "Item $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
        if (showButton) {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
//                    listState.scrollToItem(0)
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = "Scroll to top"
                )
            }
        }
    }

}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers = remember { mutableStateOf(List<Int>(size = 100) { Random.nextInt(0, 6) }) }

    val colors = listOf(
        Color(0xFFff0000),
        Color(0xFF00ff00),
        Color(0xFF0000ff),
        Color(0xFFff00ff),
        Color(0xFF00ffff),
        Color(0xFFffff00),
        Color(0xFF000000),
    )


    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(numbers.value) { randomNumber ->
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .background(colors[randomNumber]),
                contentAlignment = Alignment.Center
            ) {
                Text(text = randomNumber.toString(), color = Color.White, fontSize = 24.sp)
            }
        }


    }

}