package space.kingfu.webpage

import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.navigation.NavigationDrawer
import space.kingfu.webpage.ui.theme.KingFuTheme
import androidx.lifecycle.viewmodel.compose.viewModel



@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {

        val homeViewModel = viewModel { HomeViewModel() }

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


