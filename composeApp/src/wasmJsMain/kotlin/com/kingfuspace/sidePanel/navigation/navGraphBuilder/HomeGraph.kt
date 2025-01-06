package com.kingfuspace.sidePanel.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kingfuspace.sidePanel.home.HomeScreen
import com.kingfuspace.sidePanel.navigation.Screen


fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    composable<Screen.Home> {
        HomeScreen(
            goToBanners = {
                navController.navigate(route = Screen.Banners) {
                    launchSingleTop = true
                    restoreState = true
                }
            } 
        )
    }
}