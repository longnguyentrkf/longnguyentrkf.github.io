package org.kingfu.portfolio.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.kingfu.portfolio.home.HomeScreen
import org.kingfu.portfolio.home.viewModel.HomeViewModel
import org.kingfu.portfolio.navigation.Screen

fun NavGraphBuilder.homeGraph(
    vm: HomeViewModel
) {
    composable(route = Screen.Home.route) {

        HomeScreen(
            theme = vm.state.theme,
            setTheme = vm::setTheme,
            firstName = vm.state.firstName,
            setFirstName = vm::setFirstName,
            lastName = vm.state.lastName,
            setLastName = vm::setLastName,
            message = vm.state.message,
            setMessage = vm::setMessage
        )
    }
}