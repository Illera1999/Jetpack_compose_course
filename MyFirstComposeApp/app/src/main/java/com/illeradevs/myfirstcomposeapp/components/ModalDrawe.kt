package com.illeradevs.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.illeradevs.myfirstcomposeapp.components.state.DrawerItem
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable () -> Unit) {
    val scope = rememberCoroutineScope()
    val myItems: List<DrawerItem> = listOf(
        DrawerItem("Home", Icons.Default.Home, 0),
        DrawerItem("Fav", Icons.Default.Favorite, 7),
        DrawerItem("Profile", Icons.Default.Person, 3)
    )
    var selectedItem: Int by remember { mutableStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 0.dp,
                    bottomEnd = 20.dp,
                    bottomStart = 0.dp
                ),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.White,
                drawerTonalElevation = 10.dp,
            ) {
                Spacer(modifier = Modifier.height(44.dp))
                myItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = { Icon(item.icon, contentDescription = "Home") },
                        badge = {
                            if (item.notification > 0) {
                                Badge { Text(item.notification.toString()) }
                            }
                        },
                        shape = RoundedCornerShape(0),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedContainerColor = Color.Gray,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.White,
                        )
                    )
                }
            }
        },
        scrimColor = Color.Red.copy(alpha = 0.5f),
    ) {
        content()
    }
}