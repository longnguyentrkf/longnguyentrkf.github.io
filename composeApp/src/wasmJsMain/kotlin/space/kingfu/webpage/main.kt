package space.kingfu.webpage

import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.navigation.NavigationDrawer
import space.kingfu.webpage.ui.theme.KingFuTheme
import space.kingfu.webpage.ui.theme.ThemeType


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {

        val homeViewModel by remember { mutableStateOf(value = HomeViewModel()) }

        KingFuTheme(
            theme = homeViewModel.state.theme,
            content = {
                Surface {
                    NavigationDrawer(
                        homeViewModel = homeViewModel
                    )
                }
            }
        )
    }
}


