package space.kingfu.webpage.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import space.kingfu.webpage.flow.viewModel.FlowViewModel
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.navigation.navGraphBuilder.homeGraph
import space.kingfu.webpage.navigation.navGraphBuilder.flowGraph
import space.kingfu.webpage.navigation.navGraphBuilder.shopGraph
import space.kingfu.webpage.navigation.navGraphBuilder.templatesGraph


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    toggleDrawer: () -> Unit,
    navController: NavHostController
) {
    val flowViewModel = viewModel { FlowViewModel() }



    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Templates.route
    ) {
        homeGraph(vm = homeViewModel)

        shopGraph()

        templatesGraph(navController = navController)

        flowGraph(
            vm = flowViewModel,
            navController = navController
        )
    }
}