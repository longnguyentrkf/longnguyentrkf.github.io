package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.kingfu.webpage.flow.FlowScreen
import space.kingfu.webpage.flow.viewModel.FlowViewModel
import space.kingfu.webpage.navigation.Screen


fun NavGraphBuilder.flowGraph(vm: FlowViewModel, navController: NavHostController) {
    composable(route = Screen.Flow.route) {

        FlowScreen(
            details = vm.state.details,
            addDetails = vm::addStyle,
            setStyle = vm::setStyle,
            goToTemplate = {navController.navigate(route = Screen.Templates.route)},
            removeButton = vm::removeButton,
            addButton = vm::addButton
        )
    }
}

