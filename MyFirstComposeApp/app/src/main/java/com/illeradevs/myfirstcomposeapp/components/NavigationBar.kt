package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.illeradevs.myfirstcomposeapp.R
import com.illeradevs.myfirstcomposeapp.components.state.NavItem


@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val itemList: List<NavItem> = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Fav", Icons.Default.Favorite),
        NavItem("Profile", Icons.Default.Person)
    )
    var selectedItem: Int by remember { mutableStateOf(0) }
    NavigationBar(
//        contentColor = Color.Red,
        containerColor = Color.Red,
        tonalElevation = 10.dp,

    ) {
        itemList.forEachIndexed { index, item ->
            JoseDevsItem(navItem = item, isSelected = selectedItem == index) {
                selectedItem = index
            }
        }

    }

}


@Composable
fun RowScope.JoseDevsItem(navItem: NavItem, isSelected: Boolean = false, onitemClick: () -> Unit) {

    NavigationBarItem(
        selected = isSelected, onClick = onitemClick,
        icon = {
            Icon(navItem.icon, contentDescription = "")
        },
        label = {
            Text(text = navItem.name)
        },
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red,
            selectedTextColor = Color.White,
            indicatorColor = Color.White,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            disabledIconColor = Color.Gray,
            disabledTextColor = Color.Gray

        ),

        )

}