package space.kingfu.webpage

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.browser.document
import space.kingfu.webpage.core.Variables
import space.kingfu.webpage.core.Variables.theme
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.navigation.NavigationDrawer
import space.kingfu.webpage.ui.theme.KingFuTheme


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {

        val homeViewModel = viewModel { HomeViewModel() }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Variables.maxWidth = maxWidth

            KingFuTheme(
//                theme = homeViewModel.state.theme,
                theme = theme,
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
}



