package space.kingfu.main.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.main.navigation.Screen
import space.kingfu.main.shop.ShopScreen
import space.kingfu.main.shop.viewModel.ShopViewModel


fun NavGraphBuilder.shopGraph(isSmallScreen: Boolean) {
    composable<Screen.Shop> {
        val vm = ShopViewModel()

        ShopScreen(
            isSmallScreen = isSmallScreen
        )
    }
}