package space.kingfu.sidePanel.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.dialog
import androidx.navigation.toRoute
import space.kingfu.main.editor.state.Banner
import space.kingfu.main.editor.state.BannerType
import space.kingfu.sidePanel.navigation.navGraphBuilder.bannerGraph
import space.kingfu.sidePanel.navigation.navGraphBuilder.bannersGraph
import space.kingfu.sidePanel.navigation.navGraphBuilder.homeGraph
import space.kingfu.sidePanel.ui.components.dialog.DialogConfirm
import space.kingfu.sidePanel.ui.components.dialog.DialogEditText
import space.kingfu.sidePanel.ui.components.dialog.DialogSelect

@Composable
fun SidePanelNavHost(
    modifier: Modifier = Modifier,
    banners: MutableList<Banner>,
    addBanner: () -> Unit,
    deleteBanner: (Int) -> Unit,
    setBannerIndex: (Int?) -> Unit,
    bannerIndex: Int?,
    setBannerName: (Int, String) -> Unit,
    setBannerType: (Int, BannerType) -> Unit,
    navController: NavHostController,
    lazyListState: LazyListState,
    setBannerHeight: (Int, Dp) -> Unit,
    setBannerIsReverse: (Int, Boolean) -> Unit,
    setBannerImage: (Int, Int, String) -> Unit,
    addBannerText: (Int) -> Unit,
    setBannerText: (Int, Int, String) -> Unit,
    setBannerTextName: (Int, Int, String) -> Unit,
    removeBannerText: (Int, Int) -> Unit,
    addBannerImage: (Int) -> Unit
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        homeGraph(navController = navController)

        bannersGraph(
            banners = banners,
            navController = navController,
            addBanner = addBanner,
            setBannerIndex = setBannerIndex,
            bannerIndex = bannerIndex,
            lazyListState = lazyListState
        )

        bannerGraph(
            banners = banners,
            bannerIndex = bannerIndex,
            navController = navController,
            setBannerIndex = setBannerIndex,
            setBannerHeight = setBannerHeight,
            setBannerIsReverse = setBannerIsReverse,
            setBannerImage = setBannerImage,
            addBannerText = addBannerText,
            setBannerText = setBannerText,
            addBannerImage = addBannerImage
        )

        dialog<Dialog.DeleteBanner> {
            val data: Dialog.DeleteBanner = it.toRoute()

            DialogConfirm(
                title = data.title,
                text = data.text,
                onDismiss = navController::navigateUp,
                onConfirm = {
                    deleteBanner(data.index)
                    setBannerIndex(null)
                }
            )
        }

        dialog<Dialog.SetBannerName> {
            val data: Dialog.SetBannerName = it.toRoute()

            if (bannerIndex != null) {
                DialogEditText(
                    title = data.text,
                    textValue = banners[bannerIndex].name,
                    onDismiss = navController::navigateUp,
                    onConfirm = { string ->
                        setBannerName(data.index, string)
                    }
                )
            }
        }

        dialog<Dialog.SetBannerType> {
            val data: Dialog.SetBannerType = it.toRoute()

            if (bannerIndex != null) {
                DialogSelect(
                    onDismiss = navController::navigateUp,
                    options = BannerType.entries,
                    defaultOption = banners[data.index].type,
                    onConfirm = { type ->
                        setBannerType(data.index, type)
                    }
                )
            }
        }

    }
}
