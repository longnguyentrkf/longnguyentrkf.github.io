package com.kingfuspace.main.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kingfuspace.main.navigation.Screen
import com.kingfuspace.main.shop.ShopScreen
import com.kingfuspace.main.shop.viewModel.ShopViewModel


fun NavGraphBuilder.shopGraph(
//    isSmallScreen: Boolean
) {
    composable<Screen.Shop> {
        val vm = ShopViewModel()

        ShopScreen(
//            isSmallScreen = isSmallScreen
        )
    }
}