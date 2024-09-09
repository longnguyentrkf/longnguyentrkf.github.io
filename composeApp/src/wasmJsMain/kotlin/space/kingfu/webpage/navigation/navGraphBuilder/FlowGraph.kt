package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.flow.FlowScreen
import space.kingfu.webpage.flow.viewModel.FlowViewModel


fun NavGraphBuilder.flowGraph() {
    composable(route = Screen.Flow.route) {
        val vm = viewModel { FlowViewModel() }

        FlowScreen(
            details = vm.state.details,
            addDetails = vm::addDetail,
            setTitleFirst = vm::setTitleFirst,
            setTitleSecond = vm::setTitleSecond,
            setSubtitleFirst = vm::setSubtitleFirst,
            setSubtitleSecond = vm::setSubtitleSecond,

        )
    }
}