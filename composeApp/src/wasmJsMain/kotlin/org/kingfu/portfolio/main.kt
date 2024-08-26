package org.kingfu.portfolio

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.kingfu.portfolio.navigation.NavigationDrawer

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
//        App()
        MaterialTheme {
            Surface {
                NavigationDrawer()
            }
        }
    }
}