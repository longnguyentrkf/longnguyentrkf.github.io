package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.flow.FlowScreen
import space.kingfu.webpage.flow.viewModel.FlowViewModel


fun NavGraphBuilder.flowGraph(vm: FlowViewModel) {
    composable(route = Screen.Flow.route) {

        FlowScreen(
            details = vm.state.details,
            addDetails = vm::addDetail,
            setSection = vm::setSection,
            setStyle = vm::setStyle
        )
    }
}

