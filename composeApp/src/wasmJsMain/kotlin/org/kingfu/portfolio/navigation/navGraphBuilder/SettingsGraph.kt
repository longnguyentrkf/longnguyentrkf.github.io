package org.kingfu.portfolio.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.settings.SettingsScreen
import org.kingfu.portfolio.settings.viewModel.SettingsViewModel


fun NavGraphBuilder.settingsGraph(
    goBack: () -> Unit,
    vm: SettingsViewModel
) {
    composable(route = Screen.Settings.route) {
        SettingsScreen(
            goBack = goBack,
            theme = vm.state.theme,
            setTheme = vm::setTheme,
            isShowDialogTheme = vm.state.isShowDialogTheme,
            setIsShowDialogTheme = vm::setIsShowDialogTheme
        )
    }
}
