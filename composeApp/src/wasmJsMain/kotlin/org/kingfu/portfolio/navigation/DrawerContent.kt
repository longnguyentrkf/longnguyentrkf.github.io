package org.kingfu.portfolio.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    route: String?,
    navController: NavHostController,
    toggleDrawer: () -> Unit,
    screens: List<Screen>,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxHeight()
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.Center
    ) {
        screens.forEach { screen ->
            val selected = route == screen.route
            val color by animateColorAsState(
                targetValue = if (selected) colorScheme.primary else colorScheme.outline,
                label = ""
            )
            NavigationDrawerItem(
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                icon = {
                    val icon = if (selected) screen.iconFilled else screen.iconOutlined
                    if (icon != null) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = color
                        )
                    }
                },
                label = {
                    Text(
                        text = screen.name,
                        overflow = TextOverflow.Ellipsis,
                        color = color
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(route = screen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                    toggleDrawer()
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Transparent,
                    selectedContainerColor = Transparent
                )
            )
        }
    }
}