package space.kingfu.webpage.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Shop
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val name: String,
    val iconFilled: ImageVector? = null,
    val iconOutlined: ImageVector? = null
) {
    data object Home : Screen(
        route = "home",
        name = "Home",
        iconFilled = Icons.Filled.Home,
        iconOutlined = Icons.Outlined.Home
    )

    data object Shop : Screen(
        route = "shop",
        name = "Shop",
        iconFilled = Icons.Filled.Shop,
        iconOutlined = Icons.Outlined.Shop
    )

}