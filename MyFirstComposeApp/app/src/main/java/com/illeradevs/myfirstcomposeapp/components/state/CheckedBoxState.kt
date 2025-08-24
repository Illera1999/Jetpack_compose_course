package com.illeradevs.myfirstcomposeapp.components.state

data class CheckedBoxState(
    val id:String,
    val label:String,
    val isChecked:Boolean = false
)