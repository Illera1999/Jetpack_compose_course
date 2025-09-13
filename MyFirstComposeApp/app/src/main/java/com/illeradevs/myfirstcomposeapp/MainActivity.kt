package com.illeradevs.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.illeradevs.myfirstcomposeapp.components.MyFAB
import com.illeradevs.myfirstcomposeapp.components.MyModalDrawer
import com.illeradevs.myfirstcomposeapp.components.MyNavigationBar
import com.illeradevs.myfirstcomposeapp.components.MyTopAppBar
import com.illeradevs.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                MyModalDrawer(
                    drawerState = drawerState
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            MyTopAppBar() {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        },
                        snackbarHost = {
                            SnackbarHost(hostState = snackbarHostState)
                        },
                        floatingActionButton = {
                            MyFAB()
                        },
                        bottomBar = { MyNavigationBar() },
                        floatingActionButtonPosition = FabPosition.Start
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(Color.Cyan),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Esta esw mi screen",
                                modifier = Modifier.clickable {
                                    scope.launch {
                                        val result = snackbarHostState.showSnackbar(
                                            "Hola",
                                            actionLabel = "Deshacer",
                                        )
                                        if (result == SnackbarResult.ActionPerformed) {
                                            // Pulso deshacer
                                            println("Pulso deshacer")
                                        } else {
                                            // no hizo nada
                                            println("No pulso nada")
                                        }
                                    }
                                },
                            )
                        }
//                    MyExposedDropDownMenu(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}