package space.kingfu.main.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.main.home.HomeScreen
import space.kingfu.main.home.viewModel.HomeViewModel
import space.kingfu.main.navigation.Screen


fun NavGraphBuilder.homeGraph(
    vm: HomeViewModel,
    isSmallScreen: Boolean
) {
    composable<Screen.Home> {
        HomeScreen(
            firstName = vm.state.firstName,
            setFirstName = vm::setFirstName,
            lastName = vm.state.lastName,
            setLastName = vm::setLastName,
            message = vm.state.message,
            setMessage = vm::setMessage,
            header = vm.state.header,
            isSmallScreen = isSmallScreen
        )
    }
}