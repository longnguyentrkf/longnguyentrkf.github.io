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
            banners = vm.state.banners,
            addDetails = vm::addStyle,
            goToTemplate = {navController.navigate(route = Screen.Templates.route)},
            removeButton = vm::removeButton,
            addButton = vm::addButton,
            setTitle = vm::setTitle,
            setSubtitle = vm::setSubtitle,
            setBody = vm::setBody,
            setFooter = vm::setFooter,
            setButtons = vm::setButtons,
            setImage = vm::setImage,
            setImageHeader = vm::setImageHeader,
            header = vm.state.header,
            setTitleHeader = vm::setTitleHeader,
            setSubtitleHeader = vm::setSubtitleHeader,
            setButtonsHeader = vm::setButtonsHeader,
            addButtonHeader = vm::addButtonHeader,
            removeButtonHeader = vm::removeButtonHeader
        )
    }
}

