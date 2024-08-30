package org.kingfu.portfolio.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.kingfu.portfolio.home.viewModel.HomeViewModel
import org.kingfu.portfolio.navigation.navGraphBuilder.homeGraph


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()
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
        homeGraph(
            vm = homeViewModel
        )
    }
}