package com.kingfuspace.sidePanel.navigation.navGraphBuilder

import androidx.compose.foundation.lazy.LazyListState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.sidePanel.banners.BannersScreen
import com.kingfuspace.sidePanel.navigation.Dialog
import com.kingfuspace.sidePanel.navigation.Screen


fun NavGraphBuilder.bannersGraph(
    banners: MutableList<Banner>,
    navController: NavHostController,
    addBanner: () -> Unit,
    setIndex: (Int?) -> Unit,
    bannerIndex: Int?,
    lazyListState: LazyListState,
) {
    composable<Screen.Banners> {

        BannersScreen(
            banners = banners,
            goToBanner = {
                navController.navigate(route = Screen.Banner) {
                    launchSingleTop = true
                    restoreState = true
                }
            },
            goToDialogConfirm = {
                if(bannerIndex != null) {
                    navController.navigate(
                        route = Dialog.DeleteBanner(
                            index = bannerIndex,
                            title = "Delete",
                            text = "Are you sure you want to delete:\n${banners[bannerIndex].name}"
                        )
                    ){
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            goToDialogEditText = {
                if(bannerIndex != null) {
                    navController.navigate(
                        route = Dialog.SetBannerName(
                            title = banners[bannerIndex].name,
                            bannerIndex = bannerIndex,
                            text = banners[bannerIndex].name
                        )
                    ){
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            goBack = navController::navigateUp,
            addBanner = addBanner,
            setBannerIndex = setIndex,
            lazyListState = lazyListState
        )
    }
}