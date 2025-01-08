package com.kingfuspace.sidePanel.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class SidePanelDestination(
    val label: String,
    val screen: Screen,
    val icon: ImageVector? = null
) {
    HOME(
        label = "Home",
        screen = Screen.Home,
        icon = Icons.Rounded.Home
    ),
    BANNERS(
        label = "Banners",
        screen = Screen.Banners,

    ),
    BANNER(
        label = "Banner",
        screen = Screen.Banner
    ),
//    COMPONENT_IMAGE(
//        label = "Image",
//        screen = Screen.ComponentImage(index = 0)
//    )
}