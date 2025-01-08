package com.kingfuspace.main.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kingfuspace.main.editor.viewModel.EditorViewModel
import com.kingfuspace.main.home.viewModel.HomeViewModel
import com.kingfuspace.main.navigation.navGraphBuilder.editorGraph
import com.kingfuspace.main.navigation.navGraphBuilder.homeGraph
import com.kingfuspace.main.navigation.navGraphBuilder.shopGraph
import com.kingfuspace.main.ui.theme.ThemeType


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