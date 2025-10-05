package com.illeradevs.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.SettingModel
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.SettingScreen
import com.illeradevs.myfirstcomposeapp.components.navigation.types.createNavType
import com.illeradevs.myfirstcomposeapp.components.navigation.types.settingsModelType
import kotlin.reflect.typeOf


@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Login
    ) {
        composable<Login> {
            LoginScreen(navigateToDetail = {
                navController.navigate(Home)
            })
        }
        composable<Home> {
            HomeScreen(
                navigateBack = {
                    navController.popBackStack()
                },
                navigateToDetail = { id, jose ->
                    navController.navigate(Detail(id = id, test = jose))
                },
            )
        }
        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()
            println(detail.test)
            DetailScreen(
                id = detail.id,
                navihateToSetting = {
                    navController.navigate(Settings(settingModel = it))
                }
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())) { navBackStackEntry ->
            val settings = navBackStackEntry.toRoute<Settings>()
            SettingScreen(
                settingModel = settings.settingModel,
                navigateBack = {
                    navController.navigate(Login){
                        popUpTo<Login>{
                            inclusive = true
                        }
                    }
//                    navController.popBackStack()
                }
            )
        }
    }
}