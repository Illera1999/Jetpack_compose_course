package com.illeradevs.myfirstcomposeapp.components.navigation.types

import android.net.Uri
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.illeradevs.myfirstcomposeapp.components.navigation.examples.SettingModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val settingsModelType = object : NavType<SettingModel>(
    isNullableAllowed = true
) {
    override fun put(bundle: SavedState, key: String, value: SettingModel) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: SavedState, key: String): SettingModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, SettingModel::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): SettingModel {
        return Json.decodeFromString<SettingModel>(value)
    }

    override fun serializeAsValue(value: SettingModel): String {
        return Uri.encode(Json.encodeToString<SettingModel>(value))
    }
}