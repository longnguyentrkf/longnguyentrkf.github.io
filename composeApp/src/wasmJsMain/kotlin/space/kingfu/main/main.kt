package space.kingfu.main

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeViewport
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.browser.document
import space.kingfu.main.home.viewModel.HomeViewModel
import space.kingfu.main.navigation.NavigationDrawer
import space.kingfu.main.ui.theme.KingFuTheme
import space.kingfu.main.ui.theme.ThemeType


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {

        val homeViewModel = viewModel { HomeViewModel() }
        var screenWidth by rememberSaveable { mutableStateOf(value = 0.dp) }
        var isSmallScreen by rememberSaveable { mutableStateOf(value = screenWidth < 600.dp) }
        var theme by rememberSaveable { mutableStateOf(value = ThemeType.LIGHT) }

        fun setTheme(themeType: ThemeType) {
            theme = if (themeType == ThemeType.DARK) ThemeType.LIGHT else ThemeType.DARK
        }

        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            screenWidth = maxWidth
            isSmallScreen = screenWidth < 600.dp

            KingFuTheme(
                theme = theme,
                content = {
                    Surface(color = Color.Transparent) {
                        NavigationDrawer(
                            homeViewModel = homeViewModel,
                            setTheme = ::setTheme,
                            theme = theme,
                            isSmallScreen = isSmallScreen,
                            screenWidth = screenWidth
                        )
                    }
                }
            )
        }
    }
}



