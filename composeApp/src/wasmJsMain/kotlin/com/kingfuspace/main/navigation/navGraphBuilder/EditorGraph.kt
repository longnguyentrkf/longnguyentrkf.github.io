package com.kingfuspace.main.navigation.navGraphBuilder

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingfuspace.main.editor.screen.EditorScreen
import com.kingfuspace.main.editor.viewModel.EditorViewModel
import com.kingfuspace.main.navigation.Screen
import com.kingfuspace.sidePanel.navigation.SidePanelNavHost


fun NavGraphBuilder.editorGraph(
    editorViewModel: EditorViewModel,
//    isSmallScreen: Boolean,
//    screenWidth: Dp
) {

    composable<Screen.Editor> {
        val navController2 = rememberNavController()
        val lazyListState = rememberLazyListState()
        val sidePanelWidth = 300.dp


        Row {

            SidePanelNavHost(
                modifier = Modifier.width(width = sidePanelWidth),
                banners = editorViewModel.state.banners,
                addBanner = editorViewModel::addBanner,
                deleteBanner = editorViewModel::deleteBanner,
                setIndex = editorViewModel::setIndex,
                bannerIndex = editorViewModel.state.bannerIndex,
                setName = editorViewModel::setName,
                setType = editorViewModel::setType,
                navController = navController2,
                lazyListState = lazyListState,
                setHeight = editorViewModel::setHeight,
                setIsReverse = editorViewModel::setIsReverse,
                setImage = editorViewModel::setImage,
                addText = editorViewModel::addText,
                setTextValue = editorViewModel::setTextValue,
                setTextName = editorViewModel::setTextName,
                deleteText = editorViewModel::deleteText,
                addImage = editorViewModel::addImage,
                deleteImage = editorViewModel::deleteImage,
                swapImage = editorViewModel::swapImages,
                moveImage = editorViewModel::moveImages,
                setImageName = editorViewModel::setImageName,
                swapTexts = editorViewModel::swapTexts,
                moveTexts = editorViewModel::moveTexts,
                swapBanners = editorViewModel::swapBanners,
                moveBanners = editorViewModel::moveBanners
            )

            VerticalDivider()

            EditorScreen(
                banners = editorViewModel.state.banners,
                bannerIndex = editorViewModel.state.bannerIndex,
                setBannerIndex = editorViewModel::setIndex,
                goToBanner = {
                    navController2.navigate(route = com.kingfuspace.sidePanel.navigation.Screen.Banner) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                lazyListState = lazyListState,
                sidePanelWidth = sidePanelWidth
//                isSmallScreen = isSmallScreen,
//                screenWidth = screenWidth,
            )
        }
    }
}


