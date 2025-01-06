package com.kingfuspace.main.navigation

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.kingfuspace.main.home.viewModel.HomeViewModel
import com.kingfuspace.main.ui.theme.ThemeType
import com.kingfuspace.main.ui.theme.Typography
import kotlin.reflect.KFunction1


@Composable
fun NavigationDrawer(
    homeViewModel: HomeViewModel,
    setTheme: KFunction1<ThemeType, Unit>,
    theme: ThemeType,
    isSmallScreen: Boolean,
    screenWidth: Dp
) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val drawerWidth by remember { mutableFloatStateOf(value = 700f) }
    val translationX = remember { Animatable(initialValue = 0f) }
    translationX.updateBounds(lowerBound = 0f, upperBound = drawerWidth)
    val screens = AppDestination.entries
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


//    ObserveAsEvents(
//        flow = SnackbarController.events,
//        key1 = snackBarHostState
//    ) { event ->
//        scope.launch {
//            snackBarHostState.currentSnackbarData?.dismiss()
//
//            val result = snackBarHostState.showSnackbar(
//                message = event.message,
//                actionLabel = event.action?.name,
//                duration = event.duration,
//                withDismissAction = event.withDismissAction
//            )
//
//            if(result == SnackbarResult.ActionPerformed){
//                event.action?.action?.invoke()
//            }
//        }
//    }


    LaunchedEffect(key1 = isSmallScreen) {
        if (drawerState.isOpen) drawerState.close()
    }


    ModalNavigationDrawer(
        gesturesEnabled = isSmallScreen,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max),
                drawerShape = RectangleShape,
                drawerContainerColor = colorScheme.surface
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    screens.forEach { screen ->
                        val selected = currentDestination?.hierarchy?.any {
                            it.hasRoute(route = screen.screen::class)
                        } == true

                        NavigationDrawerItem(
                            icon = {
                                (if (selected) screen.iconFilled else screen.iconOutlined)?.let {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = null,
                                        tint = if (selected) colorScheme.primary else colorScheme.outline.copy(
                                            alpha = 0.5f
                                        )
                                    )
                                }
                            },
                            shape = RectangleShape,
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Transparent,
                                unselectedTextColor = colorScheme.outline.copy(alpha = 0.5f)
                            ),
                            label = { Text(text = screen.label, style = Typography.bodySmall) },
                            selected = selected,
                            onClick = {
                                scope.launch {
                                    navController.navigate(route = screen.screen) {
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                    drawerState.close()
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        AppScaffold(
            navController = navController,
            homeViewModel = homeViewModel,
            screens = screens,
            drawerState = drawerState,
            currentDestination = currentDestination,
            setTheme = setTheme,
            theme = theme,
            isSmallScreen = isSmallScreen,
            screenWidth = screenWidth
        )
    }
}

