package com.kingfuspace.main.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.kingfuspace.main.core.ObserveAsEvents
import com.kingfuspace.main.core.SnackbarController
import com.kingfuspace.main.core.SnackbarEvent
import com.kingfuspace.main.core.Variables.isSmallScreen
import com.kingfuspace.main.core.Variables.theme
import com.kingfuspace.main.core.theme.ThemeType
import com.kingfuspace.main.core.theme.setTheme
import com.kingfuspace.main.core.theme.toggle
import com.kingfuspace.main.ui.components.MyIconButton
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.kingfuspace_logo_no_background
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    drawerState: DrawerState,
    screens: List<AppDestination>,
    navController: NavHostController,
//    snackbarHostState: SnackbarHostState,
) {
    val scope = rememberCoroutineScope()
//    val snackBarHostState = remember { SnackbarHostState() }

    val snackbarHostState = remember { SnackbarHostState() }


    ObserveAsEvents(
        flow = SnackbarController.events,
        key1 = snackbarHostState
    ) { event ->
        scope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()

            val result = snackbarHostState.showSnackbar(
                message = event.message,
                actionLabel = event.action?.name,
                duration = event.duration,
                withDismissAction = event.withDismissAction
            )

            if (result == SnackbarResult.ActionPerformed) {
                event.action?.action?.invoke()
            }
        }
    }



    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            if (currentDestination?.hierarchy?.any {
                    it.hasRoute(route = Screen.Home::class) ||
                            it.hasRoute(route = Screen.Editor::class) ||
                            it.hasRoute(route = Screen.Shop::class)
                } == true) {

                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Transparent
                    ),
                    navigationIcon = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (isSmallScreen) {
                                IconButton(
                                    onClick = { scope.launch { if (drawerState.isOpen) drawerState.close() else drawerState.open() } }
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Menu,
                                        contentDescription = null
                                    )
                                }
                            }

                            IconButton(
                                enabled = false,
                                onClick = { }
                            ) {
                                Icon(
                                    modifier = Modifier.size(size = 24.dp),
                                    painter = painterResource(resource = Res.drawable.kingfuspace_logo_no_background),
                                    contentDescription = null,
                                    tint = colorScheme.inverseSurface
                                )
                            }

                            Text(
                                modifier = Modifier.clickable {
                                    scope.launch {
                                        SnackbarController.sendEvent(
                                            event = SnackbarEvent(
                                                message = "Kingfuspace.com"
                                            )
                                        )
                                    }
                                },
                                text = "Kingfuspace",
                                style = typography.bodyLarge
                            )
                        }
                    },
                    title = {
                        if (isSmallScreen) return@CenterAlignedTopAppBar

                        Row {
                            screens.forEach { screen ->
                                val isSelected = currentDestination.hierarchy.any {
                                    it.hasRoute(route = screen.screen::class)
                                }

                                val color by animateColorAsState(
                                    targetValue = if (isSelected) colorScheme.primary else colorScheme.outline.copy(
                                        alpha = 0.5f
                                    ),
                                    label = ""
                                )

                                TextButton(
                                    onClick = {
                                        if (isSelected) return@TextButton
                                        navController.navigate(route = screen.screen) {
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                ) {
                                    Text(
                                        modifier = Modifier.padding(horizontal = 8.dp),
                                        text = screen.label,
                                        style = typography.bodyLarge,
                                        color = color
                                    )
                                }

                            }
                        }

                    },
                    actions = {
                        MyIconButton(
                            imageVector = if (theme == ThemeType.LIGHT) Icons.Rounded.Bedtime else Icons.Rounded.LightMode,
                            onClick = { setTheme(themeType = theme.toggle()) }
                        )
                    }
                )
            }
        },
//        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
    ) {
        AppNavHost(
            modifier = modifier.padding(paddingValues = it),
            navController = navController,
            paddingValues = it
        )
    }
}