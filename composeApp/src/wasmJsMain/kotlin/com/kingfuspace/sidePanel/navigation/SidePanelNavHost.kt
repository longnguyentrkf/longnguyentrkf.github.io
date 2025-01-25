package com.kingfuspace.sidePanel.navigation

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
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.editor.state.ComponentType
import com.kingfuspace.main.editor.state.LayoutType
import com.kingfuspace.sidePanel.navigation.navGraphBuilder.bannerGraph
import com.kingfuspace.sidePanel.navigation.navGraphBuilder.bannersGraph
import com.kingfuspace.sidePanel.navigation.navGraphBuilder.componentImageGraph
import com.kingfuspace.sidePanel.navigation.navGraphBuilder.componentTextGraph
import com.kingfuspace.sidePanel.navigation.navGraphBuilder.homeGraph
import com.kingfuspace.sidePanel.ui.components.dialog.DialogConfirm
import com.kingfuspace.sidePanel.ui.components.dialog.DialogEditText
import com.kingfuspace.sidePanel.ui.components.dialog.DialogMoveBanners
import com.kingfuspace.sidePanel.ui.components.dialog.DialogMoveImages
import com.kingfuspace.sidePanel.ui.components.dialog.DialogMoveTexts
import com.kingfuspace.sidePanel.ui.components.dialog.DialogSelectComponent
import com.kingfuspace.sidePanel.ui.components.dialog.DialogSelectLayout

@Composable
fun SidePanelNavHost(
    modifier: Modifier = Modifier,
    banners: MutableList<Banner>,
    addBanner: () -> Unit,
    deleteBanner: (Int) -> Unit,
    setIndex: (Int?) -> Unit,
    bannerIndex: Int?,
    setName: (Int, String) -> Unit,
    setType: (Int, LayoutType) -> Unit,
    navController: NavHostController,
    lazyListState: LazyListState,
    setHeight: (Int, Dp) -> Unit,
    setIsReverse: (Int, Boolean) -> Unit,
    setImage: (Int, Int, String) -> Unit,
    addText: (Int) -> Unit,
    setTextValue: (Int, Int, String) -> Unit,
    setTextName: (Int, Int, String) -> Unit,
    deleteText: (Int, Int) -> Unit,
    addImage: (Int) -> Unit,
    deleteImage: (Int, Int) -> Unit,
    swapImage: (Int, Int, Int) -> Unit,
    moveImage: (Int, Int, Int) -> Unit,
    setImageName: (Int, Int, String) -> Unit,
    swapTexts: (Int, Int, Int) -> Unit,
    moveTexts: (Int, Int, Int) -> Unit,
    swapBanners: (Int, Int) -> Unit,
    moveBanners: (Int, Int) -> Unit
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
            setIndex = setIndex,
            bannerIndex = bannerIndex,
            lazyListState = lazyListState
        )

        bannerGraph(
            banners = banners,
            bannerIndex = bannerIndex,
            navController = navController,
            setIndex = setIndex,
            setHeight = setHeight,
            setIsReverse = setIsReverse,
            setImage = setImage,
            addText = addText,
            setTextValue = setTextValue,
            addImage = addImage,
            removeText = deleteText,
            deleteImage = deleteImage,
        )

        componentImageGraph(
            banners = banners,
            bannerIndex = bannerIndex,
            navController = navController,
            setImage = setImage
        )

        componentTextGraph(
            banners = banners,
            bannerIndex = bannerIndex,
            navController = navController
        )

        dialog<Dialog.DeleteBanner> {
            val data: Dialog.DeleteBanner = it.toRoute()

            DialogConfirm(
                title = data.title,
                text = data.text,
                onDismiss = navController::navigateUp,
                onConfirm = {
                    deleteBanner(data.index)
                    setIndex(null)
                }
            )
        }

        dialog<Dialog.SetBannerName> {
            val data: Dialog.SetBannerName = it.toRoute()

            DialogEditText(
                title = data.text,
                textValue = data.text,
                onDismiss = navController::navigateUp,
                onConfirm = { string ->
                    setName(data.bannerIndex, string)
                }
            )
        }

        dialog<Dialog.SetTextName> {
            val data: Dialog.SetTextName = it.toRoute()

            DialogEditText(
                title = data.text,
                textValue = data.text,
                onDismiss = navController::navigateUp,
                onConfirm = { string ->
                    setTextName(data.bannerIndex, data.componentIndex, string)
                },
            )
        }

        dialog<Dialog.SetImageName> {
            val data: Dialog.SetImageName = it.toRoute()

            DialogEditText(
                title = data.text,
                textValue = data.text,
                onDismiss = navController::navigateUp,
                onConfirm = { string ->
                    setImageName(data.bannerIndex, data.componentIndex, string)
                }
            )
        }

        dialog<Dialog.SetLayoutType> {
            val data: Dialog.SetLayoutType = it.toRoute()

            if (bannerIndex != null) {
                DialogSelectLayout(
                    onDismiss = navController::navigateUp,
                    options = LayoutType.entries,
                    defaultOption = banners[data.index].layoutType,
                    onConfirm = { type ->
                        setType(data.index, type)
                    }
                )
            }
        }

        dialog<Dialog.SetComponentType> {
            val data: Dialog.SetComponentType = it.toRoute()

            if (bannerIndex != null) {
                DialogSelectComponent(
                    onDismiss = navController::navigateUp,
                    options = ComponentType.entries,
//                    defaultOption = banners[data.index].layoutType,
                    defaultOption = null,
                    onConfirm = { type ->
//                        setType(data.index, type)
                    }
                )
            }
        }

        dialog<Dialog.MoveImage> {
            val data: Dialog.MoveImage = it.toRoute()

            if (bannerIndex != null) {
                val banner = banners[bannerIndex]

                if (banner is Banner.Banner1) {
                    DialogMoveImages(
                        selectedIndex = data.index,
                        images = banner.images,
                        onDismiss = navController::navigateUp,
                        onSwap = { bannerIndex: Int, selectedIndex: Int, targetedIndex: Int ->
                            swapImage(bannerIndex, selectedIndex, targetedIndex)
                        },
                        onMove = { bannerIndex: Int, selectedIndex: Int, targetedIndex: Int ->
                            moveImage(bannerIndex, selectedIndex, targetedIndex)
                        },
                        bannerIndex = bannerIndex
                    )
                }
            }
        }

        dialog<Dialog.MoveText> {
            val data: Dialog.MoveText = it.toRoute()

            if (bannerIndex != null) {
                val banner = banners[bannerIndex]

                if (banner is Banner.Banner1) {
                    DialogMoveTexts(
                        selectedIndex = data.index,
                        texts = banner.texts,
                        onDismiss = navController::navigateUp,
                        onSwap = { bannerIndex: Int, selectedIndex: Int, targetedIndex: Int ->
                            swapTexts(bannerIndex, selectedIndex, targetedIndex)
                        },
                        onMove = { bannerIndex: Int, selectedIndex: Int, targetedIndex: Int ->
                            moveTexts(bannerIndex, selectedIndex, targetedIndex)
                        },
                        bannerIndex = bannerIndex
                    )
                }
            }
        }

        dialog<Dialog.MoveBanners> {
            val data: Dialog.MoveBanners = it.toRoute()

            DialogMoveBanners(
                selectedIndex = data.index,
                banners = banners,
                onDismiss = navController::navigateUp,
                onSwap = { selectedIndex: Int, targetedIndex: Int ->
                    swapBanners(selectedIndex, targetedIndex)
                },
                onMove = { selectedIndex: Int, targetedIndex: Int ->
                    moveBanners(selectedIndex, targetedIndex)
                }
            )
        }

    }
}
