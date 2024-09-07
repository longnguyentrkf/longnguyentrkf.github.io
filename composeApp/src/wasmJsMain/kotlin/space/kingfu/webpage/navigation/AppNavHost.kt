package space.kingfu.webpage.navigation

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.createGraph
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.navigation.navGraphBuilder.homeGraph
import space.kingfu.webpage.navigation.navGraphBuilder.shopGraph
import space.kingfu.webpage.navigation.navGraphBuilder.templatesGraph


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    toggleDrawer: () -> Unit,
    navController: NavHostController
) {


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        homeGraph(vm = homeViewModel)

        shopGraph()

        templatesGraph()
    }
}