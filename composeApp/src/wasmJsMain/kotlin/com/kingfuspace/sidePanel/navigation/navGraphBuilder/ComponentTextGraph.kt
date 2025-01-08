package com.kingfuspace.sidePanel.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.sidePanel.components.ComponentImage
import com.kingfuspace.sidePanel.components.ComponentText
import com.kingfuspace.sidePanel.navigation.Dialog
import com.kingfuspace.sidePanel.navigation.Screen

fun NavGraphBuilder.componentTextGraph(
    navController: NavHostController,
    banners: MutableList<Banner>,
    bannerIndex: Int?
) {
    composable<Screen.ComponentText> { backStackEntry ->
        val data: Screen.ComponentText = backStackEntry.toRoute()

        if(bannerIndex != null ) {

            val banner = banners[bannerIndex]
            if (banner is Banner.Banner1) {
                ComponentText(
                    goBack = navController::navigateUp,
                    text = banner.texts[data.index],
                    goToSetTextName = {
                        navController.navigate(
                            route = Dialog.SetTextName(
                                bannerIndex = bannerIndex,
                                componentIndex = data.index,
                                title = banner.texts[data.index].name,
                                text = banner.texts[data.index].name
                            )
                        ) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}