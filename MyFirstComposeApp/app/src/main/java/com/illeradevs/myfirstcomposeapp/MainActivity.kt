package com.illeradevs.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.illeradevs.myfirstcomposeapp.components.MyOutlinedCard
import com.illeradevs.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyOutlinedCard(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//@Composable
//fun MyCustomScaffold(modifier: Modifier = Modifier) {
//    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    MyModalDrawer(
//        drawerState = drawerState
//    ) {
//        Scaffold(
//            modifier = Modifier.fillMaxSize(),
//            topBar = {
//                MyTopAppBar() {
//                    scope.launch {
//                        drawerState.open()
//                    }
//                }
//            },
//            snackbarHost = {
//                SnackbarHost(hostState = snackbarHostState)
//            },
//            floatingActionButton = {
//                MyFAB()
//            },
//            bottomBar = { MyNavigationBar() },
//            floatingActionButtonPosition = FabPosition.Start
//        ) { innerPadding ->
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding)
//                    .background(Color.Cyan),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Esta esw mi screen",
//                    modifier = Modifier.clickable {
//                        scope.launch {
//                            val result = snackbarHostState.showSnackbar(
//                                "Hola",
//                                actionLabel = "Deshacer",
//                            )
//                            if (result == SnackbarResult.ActionPerformed) {
//                                // Pulso deshacer
//                                println("Pulso deshacer")
//                            } else {
//                                // no hizo nada
//                                println("No pulso nada")
//                            }
//                        }
//                    },
//                )
//            }
//        }
//    }
//
//}