package space.kingfu.sidePanel.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.kingfu.sidePanel.home.HomeScreen
import space.kingfu.sidePanel.navigation.Screen


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