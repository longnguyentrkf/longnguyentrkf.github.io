package space.kingfu.sidePanel.navigation.navGraphBuilder

import androidx.compose.foundation.lazy.LazyListState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.kingfu.main.editor.state.Banner
import space.kingfu.sidePanel.banners.BannersScreen
import space.kingfu.sidePanel.navigation.Dialog
import space.kingfu.sidePanel.navigation.Screen


fun NavGraphBuilder.bannersGraph(
    banners: MutableList<Banner>,
    navController: NavHostController,
    addBanner: () -> Unit,
    setBannerIndex: (Int?) -> Unit,
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
                    )
                }
            },
            goToDialogEditText = {
                if(bannerIndex != null) {
                    navController.navigate(
                        route = Dialog.SetBannerName(
                            title = banners[bannerIndex].name,
                            index = bannerIndex,
                            text = banners[bannerIndex].name
                        )
                    )
                }
            },
            goBack = navController::navigateUp,
            addBanner = addBanner,
            setBannerIndex = setBannerIndex,
            lazyListState = lazyListState
        )
    }
}