package org.kingfu.portfolio

import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.kingfu.portfolio.navigation.NavigationDrawer
import org.kingfu.portfolio.settings.viewModel.SettingsViewModel
import org.kingfu.portfolio.ui.theme.PortfolioTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        val settingsViewModel by remember { mutableStateOf(value = SettingsViewModel()) }

        PortfolioTheme(
            theme = settingsViewModel.state.theme,
            content = {
                Surface {
                    NavigationDrawer(
                        settingsViewModel = settingsViewModel
                    )
                }
            }
        )
    }
}