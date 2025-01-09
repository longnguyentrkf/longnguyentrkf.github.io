package com.kingfuspace.main.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import com.kingfuspace.main.core.theme.ThemeType
import com.kingfuspace.main.core.Variables.theme
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import com.kingfuspace.main.core.formatEnumName
import com.kingfuspace.main.core.isSmallScreen
import com.kingfuspace.main.core.theme.setTheme
import com.kingfuspace.main.core.theme.toggle
import com.kingfuspace.main.ui.components.MyIconButton
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.kingfuspace_logo_no_background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    drawerState: DrawerState,
    screens: List<AppDestination>,
    navController: NavHostController,
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }


    Scaffold(
        topBar = {
            if (currentDestination?.hierarchy?.any {
                    it.hasRoute(route = Screen.Home::class) ||
                            it.hasRoute(route = Screen.Editor::class) ||
                            it.hasRoute(route = Screen.Shop::class)
                } == true) {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Transparent
                    ),
                    navigationIcon = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (isSmallScreen()) {
                                MyIconButton(
                                    imageVector = Icons.Rounded.Menu,
                                    onClick = {
                                        scope.launch {
                                            if (drawerState.isOpen) {
                                                drawerState.close()
                                            } else {
                                                drawerState.open()
                                            }
                                        }
                                    }
                                )
                            }
                            Icon(
                                modifier = Modifier
                                    .padding(
                                        start = if (isSmallScreen()) 0.dp else 12.dp,
                                        end = 8.dp
                                    )
                                    .size(size = 24.dp),
                                painter = painterResource(resource = Res.drawable.kingfuspace_logo_no_background),
                                contentDescription = null,
                                tint = colorScheme.inverseSurface
                            )

                            Text(
                                text = AppDestination.HOME.label,
                                style = typography.bodySmall
                            )
                        }
                    },
                    title = {
                        if (isSmallScreen()) return@TopAppBar

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
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
                                        text = screen.name.formatEnumName(),
                                        style = typography.bodySmall,
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
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
    ) {
        AppNavHost(
            modifier = modifier.padding(paddingValues = it),
            navController = navController
        )
    }
}