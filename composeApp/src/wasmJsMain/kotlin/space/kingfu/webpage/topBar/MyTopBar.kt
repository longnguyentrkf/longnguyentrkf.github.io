package space.kingfu.webpage.topBar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.kingfu_no_background_stroke_15
import org.jetbrains.compose.resources.painterResource
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    iconContainerColor: Color = Transparent,
    navigationIconOnClick: () -> Unit = {},
    isSmallScreenWidth: Boolean,
    actionContent: @Composable (RowScope.() -> Unit) = {},
    screens: List<Screen>,
    route: String?,
    navController: NavHostController
) {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            scrollBehavior = scrollBehavior,
            modifier = modifier.widthIn(max = 1200.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                scrolledContainerColor = Transparent,
                containerColor = Transparent
            ),
            navigationIcon = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isSmallScreenWidth) {
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = iconContainerColor
                            ),
                            onClick = navigationIconOnClick
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable { navController.navigate(route = Screen.Home.route) }
                            .padding(
                                horizontal = Space().medium_16,
                                vertical = Space().small_8
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(size = 24.dp),
                            painter = painterResource(resource = Res.drawable.kingfu_no_background_stroke_15),
                            contentDescription = null,
                            tint = colorScheme.inverseSurface
                        )

                        Text(
                            text = "KingFu",
                            style = Typography.bodySmall
                        )
                    }
                }
            },
            title = {
                if (!isSmallScreenWidth) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        screens.forEach { screen ->
                            val selected = route == screen.route
                            val color by animateColorAsState(
                                targetValue = if (selected) colorScheme.primary else colorScheme.outline.copy(
                                    alpha = 0.5f
                                ),
                                label = ""
                            )

                            Text(modifier = Modifier.clip(shape = CircleShape)
                                .clickable {
                                    navController.navigate(route = screen.route) {
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                                .padding(
                                    vertical = Space().small_8,
                                    horizontal = Space().medium_16
                                ),
                                text = screen.name,
                                style = Typography.bodySmall,
                                color = color
                            )
                        }
                    }
                }
            },
            actions = actionContent
        )
    }
}



