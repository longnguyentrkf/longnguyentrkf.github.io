package org.kingfu.portfolio.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.settings.SettingsScreen


fun NavGraphBuilder.settingsGraph(
    goBack: () -> Unit
) {
    composable(route = Screen.Settings.route) {
        SettingsScreen(
            goBack = goBack
        )
    }
}
