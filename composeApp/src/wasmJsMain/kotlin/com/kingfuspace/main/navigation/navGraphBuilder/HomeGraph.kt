package com.kingfuspace.main.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kingfuspace.main.home.HomeScreen
import com.kingfuspace.main.home.viewModel.HomeViewModel
import com.kingfuspace.main.navigation.Screen


fun NavGraphBuilder.homeGraph(
    vm: HomeViewModel,
//    isSmallScreen: Boolean
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
//            isSmallScreen = isSmallScreen
        )
    }
}