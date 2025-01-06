package com.kingfuspace.main.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object Shop : Screen

    @Serializable
    data object Editor : Screen
}






