package org.kingfu.portfolio.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.kingfu.portfolio.home.viewModel.HomeViewModel
import org.kingfu.portfolio.navigation.navGraphBuilder.homeGraph
import org.kingfu.portfolio.navigation.navGraphBuilder.settingsGraph
import org.kingfu.portfolio.settings.viewModel.SettingsViewModel


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    toggleDrawer: () -> Unit,
    navController: NavHostController,
    settingsViewModel: SettingsViewModel
) {
    val enterTransition = AnimatedContentTransitionScope.SlideDirection.Left
    val popTransition = AnimatedContentTransitionScope.SlideDirection.Right
    val homeViewModel by remember { mutableStateOf(value = HomeViewModel()) }


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
            toggleDrawer = toggleDrawer,
            vm = homeViewModel
        )

        settingsGraph(
            goBack = { navController.navigateUp() },
            vm = settingsViewModel
        )
    }
}