package space.kingfu.main.navigation.navGraphBuilder

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import space.kingfu.main.editor.screen.EditorScreen
import space.kingfu.main.editor.viewModel.EditorViewModel
import space.kingfu.main.navigation.Screen
import space.kingfu.sidePanel.navigation.SidePanelNavHost


fun NavGraphBuilder.editorGraph(
    editorViewModel: EditorViewModel,
    navController: NavHostController,
    isSmallScreen: Boolean,
    screenWidth: Dp
) {

    composable<Screen.Editor> {
        val navController2 = rememberNavController()
        val lazyListState = rememberLazyListState()


        Row {

            SidePanelNavHost(
                modifier = Modifier.width(width = 300.dp),
                banners = editorViewModel.state.banners,
                addBanner = editorViewModel::addBanner,
                deleteBanner = editorViewModel::deleteBanner,
                setBannerIndex = editorViewModel::setBannerIndex,
                bannerIndex = editorViewModel.state.bannerIndex,
                setBannerName = editorViewModel::setBannerName,
                setBannerType = editorViewModel::setBannerType,
                navController = navController2,
                lazyListState = lazyListState,
                setBannerHeight = editorViewModel::setBannerHeight,
                setBannerIsReverse = editorViewModel::setBannerIsReverse,
                setBannerImage = editorViewModel::setBannerImage,
                addBannerText = editorViewModel::addBannerText,
                setBannerText = editorViewModel::setBannerText,
                setBannerTextName = editorViewModel::setBannerTextName,
                removeBannerText = editorViewModel::removeBannerText,
                addBannerImage = editorViewModel::addBannerImage
            )

            VerticalDivider()

            EditorScreen(
                banners = editorViewModel.state.banners,
                bannerIndex = editorViewModel.state.bannerIndex,
                setBannerIndex = editorViewModel::setBannerIndex,
                goToBanner = {
                    navController2.navigate(route = space.kingfu.sidePanel.navigation.Screen.Banner) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                lazyListState = lazyListState,
                isSmallScreen = isSmallScreen,
                screenWidth = screenWidth,
            )
        }
    }
}


