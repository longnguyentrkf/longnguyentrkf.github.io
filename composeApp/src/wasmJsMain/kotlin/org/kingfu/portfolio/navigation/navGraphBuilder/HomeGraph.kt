package org.kingfu.portfolio.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.kingfu.portfolio.home.HomeScreen
import org.kingfu.portfolio.home.viewModel.HomeViewModel
import org.kingfu.portfolio.navigation.Screen

fun NavGraphBuilder.homeGraph(
    toggleDrawer: () -> Unit,
    vm: HomeViewModel
) {
    composable(route = Screen.Home.route) {

        HomeScreen(
            toggleDrawer = toggleDrawer,
        )
    }
}