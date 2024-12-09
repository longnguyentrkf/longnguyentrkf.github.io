package space.kingfu.sidePanel.navigation.navGraphBuilder

import androidx.compose.ui.unit.Dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.kingfu.main.editor.state.Banner
import space.kingfu.sidePanel.banner.BannerScreen
import space.kingfu.sidePanel.navigation.Dialog
import space.kingfu.sidePanel.navigation.Screen


fun NavGraphBuilder.bannerGraph(
    banners: List<Banner>,
    bannerIndex: Int?,
    navController: NavHostController,
    setBannerIndex: (Int?) -> Unit,
    setBannerHeight: (Int, Dp) -> Unit,
    setBannerIsReverse: (Int, Boolean) -> Unit,
    setBannerImage: (Int, Int, String) -> Unit,
    addBannerText: (Int) -> Unit,
    setBannerText: (Int, Int, String) -> Unit,
    addBannerImage: (Int) -> Unit
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
                    )
                },
                goToDialogEditText = {
                    navController.navigate(
                        route = Dialog.SetBannerName(
                            title = name,
                            index = bannerIndex,
                            text = name
                        )
                    )
                },
                goToDialogSelect = {
                    navController.navigate(
                        route = Dialog.SetBannerType(
                            title = name,
                            index = bannerIndex,
                            text = name
                        )
                    )
                },
                bannerIndex = bannerIndex,
                setBannerIndex = setBannerIndex,
                setBannerHeight = setBannerHeight,
                setBannerIsReverse = setBannerIsReverse,
                setBannerImage = setBannerImage,
                addBannerText = addBannerText,
                setBannerText = setBannerText,
                addBannerImage = addBannerImage
            )
        } else {
            navController.navigate(route = Screen.Banners)
        }
    }
}