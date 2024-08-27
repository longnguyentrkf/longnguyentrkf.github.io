package org.kingfu.portfolio.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
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
    val enterTransition = AnimatedContentTransitionScope.SlideDirection.Left
    val popTransition = AnimatedContentTransitionScope.SlideDirection.Right

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = {
            slideIntoContainer(towards = enterTransition)
        },
        exitTransition = {
            slideOutOfContainer(towards = enterTransition)
        },
        popEnterTransition = {
            slideIntoContainer(towards = popTransition)
        },
        popExitTransition = {
            slideOutOfContainer(towards = popTransition)
        }
    ) {
        homeGraph(toggleDrawer = toggleDrawer)

        settingsGraph(goBack = { navController.navigateUp()})
    }
}