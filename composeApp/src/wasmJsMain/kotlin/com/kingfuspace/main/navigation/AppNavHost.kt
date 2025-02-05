package com.kingfuspace.main.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kingfuspace.main.editor.viewModel.EditorViewModel
import com.kingfuspace.main.home.viewModel.HomeViewModel
import com.kingfuspace.main.navigation.navGraphBuilder.editorGraph
import com.kingfuspace.main.navigation.navGraphBuilder.homeGraph
import com.kingfuspace.main.navigation.navGraphBuilder.shopGraph


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    val editorViewModel = viewModel { EditorViewModel() }
    val homeViewModel = viewModel { HomeViewModel() }
    val mainHomeScreenScrollState = rememberScrollState()


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        homeGraph(
            vm = homeViewModel,
            paddingValues = paddingValues,
            scrollState = mainHomeScreenScrollState
        )

        editorGraph(
            editorViewModel = editorViewModel
        )

        shopGraph()
    }
}