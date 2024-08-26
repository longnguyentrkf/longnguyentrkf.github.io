package org.kingfu.portfolio.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.kingfu.portfolio.navigation.navGraphBuilder.homeGraph
import org.kingfu.portfolio.navigation.navGraphBuilder.settingsGraph


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    toggleDrawer: () -> Unit,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        homeGraph(toggleDrawer = toggleDrawer)

        settingsGraph(toggleDrawer = toggleDrawer)
    }
}