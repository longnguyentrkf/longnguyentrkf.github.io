package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.shop.ShopScreen
import space.kingfu.webpage.shop.viewModel.ShopViewModel
import space.kingfu.webpage.ui.theme.ThemeType


fun NavGraphBuilder.shopGraph(
    toggleDrawer: () -> Unit
) {
    composable(route = Screen.Shop.route) {
        val vm = ShopViewModel()

        ShopScreen(
            toggleDrawer = toggleDrawer
        )
    }
}