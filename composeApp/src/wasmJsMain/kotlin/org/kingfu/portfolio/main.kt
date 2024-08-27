package org.kingfu.portfolio

import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.kingfu.portfolio.navigation.NavigationDrawer
import org.kingfu.portfolio.theme.PortfolioTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        PortfolioTheme(
            content = {
                Surface {
                    NavigationDrawer()
                }
            }
        )
    }
}