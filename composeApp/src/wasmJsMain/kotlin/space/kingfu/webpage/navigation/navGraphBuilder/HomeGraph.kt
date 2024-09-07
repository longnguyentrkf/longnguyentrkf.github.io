package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.compose.foundation.ScrollState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.kingfu.webpage.home.HomeScreen
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.navigation.Screen


fun NavGraphBuilder.homeGraph(
    vm: HomeViewModel
) {
    composable(route = Screen.Home.route) {

        HomeScreen(
            firstName = vm.state.firstName,
            setFirstName = vm::setFirstName,
            lastName = vm.state.lastName,
            setLastName = vm::setLastName,
            message = vm.state.message,
            setMessage = vm::setMessage,
        )
    }
}