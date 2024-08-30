package org.kingfu.portfolio

import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.kingfu.portfolio.home.viewModel.HomeViewModel
import org.kingfu.portfolio.navigation.AppNavHost
import org.kingfu.portfolio.ui.theme.PortfolioTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        val homeViewModel by remember { mutableStateOf(value = HomeViewModel()) }

        PortfolioTheme(
            theme = homeViewModel.state.theme,
            content = {
                Surface {
                    AppNavHost(
                        homeViewModel = homeViewModel
                    )
                }
            }
        )
    }
}


