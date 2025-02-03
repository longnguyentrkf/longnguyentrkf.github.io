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
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kingfuspace.main.core.ObserveAsEvents
import com.kingfuspace.main.core.SnackbarController
import com.kingfuspace.main.core.Variables.isSmallScreen
import com.kingfuspace.main.core.Variables.windowInnerWidth
import kotlinx.coroutines.launch


@Composable
fun NavigationDrawer() {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val drawerWidth by remember { mutableFloatStateOf(value = 700f) }
    val translationX = remember { Animatable(initialValue = 0f) }
    translationX.updateBounds(lowerBound = 0f, upperBound = drawerWidth)
    val screens = AppDestination.entries
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    LaunchedEffect(key1 = windowInnerWidth) {
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
                            label = { Text(text = screen.label, style = typography.bodyLarge) },
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
            screens = screens,
            drawerState = drawerState,
            currentDestination = currentDestination,
//            snackbarHostState = snackBarHostState
        )
    }
}

