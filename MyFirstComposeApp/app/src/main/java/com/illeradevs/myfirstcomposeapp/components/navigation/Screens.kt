package com.illeradevs.myfirstcomposeapp.components.navigation

import com.illeradevs.myfirstcomposeapp.components.navigation.examples.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test: Boolean )

@Serializable
data class Settings(val settingModel: SettingModel)