package com.kingfuspace.main.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ViewQuilt
import androidx.compose.material.icons.automirrored.outlined.ViewQuilt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.ui.graphics.vector.ImageVector


enum class AppDestination(
    val iconFilled: ImageVector? = null,
    val iconOutlined: ImageVector? = null,
    val label: String,
    val screen: Screen
) {
    HOME(
        iconFilled = Icons.Filled.Home,
        iconOutlined = Icons.Outlined.Home,
        label = "Home",
        screen = Screen.Home
    ),
    EDITOR(
        iconFilled = Icons.AutoMirrored.Filled.ViewQuilt,
        iconOutlined = Icons.AutoMirrored.Outlined.ViewQuilt,
        label = "Editor",
        screen = Screen.Editor
    ),
    SHOP(
        iconFilled = Icons.Filled.Storefront,
        iconOutlined = Icons.Outlined.Storefront,
        label = "Shop",
        screen = Screen.Shop
    ),

//    HOME2(
//        label = "Home",
//        screen = Screen.Home2
//    ),
//    BANNERS(
//        label = "Banners",
//        screen = Screen.Banners
//    ),

}


