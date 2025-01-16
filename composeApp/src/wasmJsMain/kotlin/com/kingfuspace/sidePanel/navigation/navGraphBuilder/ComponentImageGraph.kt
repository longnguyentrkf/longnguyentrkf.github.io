package com.kingfuspace.sidePanel.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.sidePanel.components.ComponentImage
import com.kingfuspace.sidePanel.navigation.Dialog
import com.kingfuspace.sidePanel.navigation.Screen

fun NavGraphBuilder.componentImageGraph(
    navController: NavHostController,
    banners: MutableList<Banner>,
    bannerIndex: Int?,
    setImage: (Int, Int, String) -> Unit
) {
    composable<Screen.ComponentImage> { backStackEntry ->
        val data: Screen.ComponentImage = backStackEntry.toRoute()

        if(bannerIndex != null ) {

            val banner = banners[bannerIndex]
            if (banner is Banner.Banner1) {
                ComponentImage(
                    goBack = navController::navigateUp,
                    image = banner.images[data.index],
                    goToSetTextName = {
                        navController.navigate(
                            route = Dialog.SetImageName(
                                bannerIndex = bannerIndex,
                                componentIndex = data.index,
                                title = banner.images[data.index].name,
                                text = banner.images[data.index].name
                            )
                        ){
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    index = data.index,
                    bannerIndex = bannerIndex,
                    setImage = setImage
                )
            }
        }
    }
}