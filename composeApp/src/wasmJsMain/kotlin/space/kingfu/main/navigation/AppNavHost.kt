package space.kingfu.main.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import space.kingfu.main.editor.viewModel.EditorViewModel
import space.kingfu.main.home.viewModel.HomeViewModel
import space.kingfu.main.navigation.navGraphBuilder.editorGraph
import space.kingfu.main.navigation.navGraphBuilder.homeGraph
import space.kingfu.main.navigation.navGraphBuilder.shopGraph


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    navController: NavHostController,
    isSmallScreen: Boolean,
    screenWidth: Dp
) {
    val editorViewModel = viewModel { EditorViewModel() }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Editor,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        homeGraph(
            vm = homeViewModel,
            isSmallScreen = isSmallScreen
        )

        editorGraph(
            editorViewModel = editorViewModel,
            navController = navController,
            isSmallScreen = isSmallScreen,
            screenWidth = screenWidth
        )

        shopGraph(
            isSmallScreen = isSmallScreen
        )
    }
}