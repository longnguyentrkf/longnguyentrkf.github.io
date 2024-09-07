package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.compose.foundation.ScrollState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.shop.ShopScreen
import space.kingfu.webpage.shop.viewModel.ShopViewModel


fun NavGraphBuilder.shopGraph() {
    composable(route = Screen.Shop.route) {
        val vm = ShopViewModel()

        ShopScreen()
    }
}