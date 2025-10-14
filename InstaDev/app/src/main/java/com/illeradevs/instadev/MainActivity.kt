package com.illeradevs.instadev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.illeradevs.instadev.ui.theme.InstDevTheme
import com.illeradevs.instadev.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstDevTheme {
                NavigationWrapper()
            }
        }
    }
}