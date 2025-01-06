package com.kingfuspace.sidePanel.navigation.navGraphBuilder

import androidx.compose.ui.unit.Dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.sidePanel.banner.BannerScreen
import com.kingfuspace.sidePanel.navigation.Dialog
import com.kingfuspace.sidePanel.navigation.Screen


fun NavGraphBuilder.bannerGraph(
    banners: List<Banner>,
    bannerIndex: Int?,
    navController: NavHostController,
    setIndex: (Int?) -> Unit,
    setHeight: (Int, Dp) -> Unit,
    setIsReverse: (Int, Boolean) -> Unit,
    setImage: (Int, Int, String) -> Unit,
    addText: (Int) -> Unit,
    setTextValue: (Int, Int, String) -> Unit,
    addImage: (Int) -> Unit,
    removeText: (Int, Int) -> Unit,
    deleteImage: (Int, Int) -> Unit
) {
    composable<Screen.Banner> {
        if (bannerIndex != null && bannerIndex <= banners.size - 1) {
            val name = banners[bannerIndex].name
            BannerScreen(
                banner = banners[bannerIndex],
                goBack = navController::navigateUp,
                goToDialogConfirm = {
                    navController.navigate(
                        route = Dialog.DeleteBanner(
                            index = bannerIndex,
                            title = "Delete",
                            text = "Are you sure you want to delete:\n$name"
                        )
                    ) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToSetBannerName = {
                    navController.navigate(
                        route = Dialog.SetBannerName(
                            title = name,
                            bannerIndex = bannerIndex,
                            text = name
                        )
                    ) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToSetTextName = { title: String, componentIndex: Int ->
                    navController.navigate(
                        route = Dialog.SetTextName(
                            title = title,
                            bannerIndex = bannerIndex,
                            componentIndex = componentIndex,
                            text = title
                        )
                    ) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToSetImageName = { title: String, componentIndex: Int ->
                    navController.navigate(
                        route = Dialog.SetImageName(
                            title = title,
                            bannerIndex = bannerIndex,
                            componentIndex = componentIndex,
                            text = title
                        )
                    ){
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToDialogSelect = {
                    navController.navigate(
                        route = Dialog.SetBannerType(
                            title = name,
                            index = bannerIndex,
                            text = name
                        )
                    ) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToDialogMoveImages = { index: Int ->
                    navController.navigate(
                        route = Dialog.MoveImage(
                            index = index
                        )
                    ) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToDialogMoveTexts = { index: Int ->
                    navController.navigate(
                        route = Dialog.MoveText(
                            index = index
                        )
                    ) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                goToComponentImage = { index: Int ->
                    navController.navigate(route = Screen.ComponentImage(index = index)) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                bannerIndex = bannerIndex,
                setIndex = setIndex,
                setHeight = setHeight,
                setIsReverse = setIsReverse,
                setImage = setImage,
                addText = addText,
                setTextValue = setTextValue,
                addImage = addImage,
                deleteText = removeText,
                deleteImage = deleteImage
            )
        } else {
            navController.navigate(route = Screen.Banners){
                launchSingleTop = true
                restoreState = true
            }
        }
    }
}