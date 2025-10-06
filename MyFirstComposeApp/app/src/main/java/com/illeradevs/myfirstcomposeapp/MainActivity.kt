package com.illeradevs.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.illeradevs.myfirstcomposeapp.components.MyAdvanseList
import com.illeradevs.myfirstcomposeapp.components.MyBadgedBox
import com.illeradevs.myfirstcomposeapp.components.MyBasicList
import com.illeradevs.myfirstcomposeapp.components.MyCustomDialog
import com.illeradevs.myfirstcomposeapp.components.MyDateDialog
import com.illeradevs.myfirstcomposeapp.components.MyDialog
import com.illeradevs.myfirstcomposeapp.components.MyDivider
import com.illeradevs.myfirstcomposeapp.components.MyGridList
import com.illeradevs.myfirstcomposeapp.components.MyOutlinedCard
import com.illeradevs.myfirstcomposeapp.components.MyTimePicker
import com.illeradevs.myfirstcomposeapp.components.ScrollList
import com.illeradevs.myfirstcomposeapp.components.advance.InteractionSourceExample
import com.illeradevs.myfirstcomposeapp.components.advance.MyDerivedSatateOf
import com.illeradevs.myfirstcomposeapp.components.advance.MyLaunchedEffect
import com.illeradevs.myfirstcomposeapp.components.animations.FullAnimateAsState
import com.illeradevs.myfirstcomposeapp.components.animations.MyAnimateContentSize
import com.illeradevs.myfirstcomposeapp.components.animations.MyAnimatedContent
import com.illeradevs.myfirstcomposeapp.components.animations.MyAnimatedVisibility
import com.illeradevs.myfirstcomposeapp.components.animations.MyCrossfade
import com.illeradevs.myfirstcomposeapp.components.navigation.NavigationWrapper
import com.illeradevs.myfirstcomposeapp.state.PokemonCombat
import com.illeradevs.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAnimateContentSize(
                        Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}