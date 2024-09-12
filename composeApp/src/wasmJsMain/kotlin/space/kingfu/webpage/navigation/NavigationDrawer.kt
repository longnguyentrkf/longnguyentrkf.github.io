package space.kingfu.webpage.navigation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import space.kingfu.webpage.core.isSmallScreen
import space.kingfu.webpage.home.viewModel.HomeViewModel
import space.kingfu.webpage.topBar.MyTopBar
import space.kingfu.webpage.ui.theme.ThemeType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()
    val route = navController.currentBackStackEntryAsState().value?.destination?.route
    var drawerState by rememberSaveable { mutableStateOf(value = DrawerValue.Closed) }
    val drawerWidth by remember { mutableFloatStateOf(value = 700f) }
    val translationX = remember { Animatable(initialValue = 0f) }
    translationX.updateBounds(lowerBound = 0f, upperBound = drawerWidth)
    val scope = rememberCoroutineScope()
    val decay = rememberSplineBasedDecay<Float>()
    val draggableState = rememberDraggableState(onDelta = { dragAmount ->
        scope.launch { translationX.snapTo(targetValue = translationX.value + dragAmount) }
    })
    val isDrawerOpen = drawerState == DrawerValue.Open
    val snackBarHostState = remember { SnackbarHostState() }
    val screens = listOf(Screen.Home, Screen.Templates, Screen.Shop)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()


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

    fun toggleDrawer() {
        scope.launch {
            translationX.animateTo(targetValue = if (isDrawerOpen) 0f else drawerWidth)
            drawerState = if (isDrawerOpen) DrawerValue.Closed else DrawerValue.Open
        }
    }


    fun onDragStopped(velocity: Float) {
        val decayX = decay.calculateTargetValue(
            translationX.value, velocity
        )

        scope.launch {
            val targetX = if (decayX > drawerWidth * 0.5) drawerWidth else 0f
            val canReachTargetWithDecay =
                (decayX > targetX && targetX == drawerWidth) || (decayX < targetX && targetX == 0f)

            if (canReachTargetWithDecay) {
                translationX.animateDecay(initialVelocity = velocity, animationSpec = decay)
            } else {
                translationX.animateTo(targetValue = targetX, initialVelocity = velocity)
            }

            drawerState = if (targetX == drawerWidth) DrawerValue.Open else DrawerValue.Closed

        }
    }

    BoxWithConstraints {
        val maxWidth = maxWidth
        val isDragEnabled = isSmallScreen(width = maxWidth)

        Scaffold(
            modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
            topBar = {
                MyTopBar(
                    modifier = Modifier
                        .graphicsLayer { this.translationX = translationX.value }
                        .alpha(
                            alpha = 1 - 0.5f * (translationX.value / drawerWidth).coerceIn(
                                0f,
                                1f
                            )
                        ),
                    scrollBehavior = scrollBehavior,
                    screens = screens,
                    navigationIconOnClick = { toggleDrawer() },
                    actionContent = {
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(),
                            onClick = { homeViewModel.setTheme(homeViewModel.state.theme) }) {
                            Icon(
                                imageVector = if (homeViewModel.state.theme == ThemeType.LIGHT) Icons.Default.Bedtime else Icons.Default.LightMode,
                                contentDescription = null
                            )
                        }
                    },
                    route = route,
                    isSmallScreenWidth = isSmallScreen(maxWidth),
                    navController = navController
                )
            },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) {
            DrawerContent(navController = navController,
                toggleDrawer = ::toggleDrawer,
                route = route,
                modifier = Modifier.width(width = drawerWidth.dp * 0.5f)
                    .graphicsLayer { this.translationX = translationX.value - drawerWidth }
                    .draggable(enabled = isDragEnabled,
                        state = draggableState,
                        orientation = Orientation.Horizontal,
                        onDragStopped = { onDragStopped(velocity = it) }),
                screens = screens
            )

            Box {
                if (translationX.value > 0f) {
                    Box(
                        modifier = Modifier.zIndex(zIndex = 1f)
                            .matchParentSize()
                            .graphicsLayer { this.translationX = translationX.value }
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = { toggleDrawer() })
                            .draggable(enabled = isDragEnabled,
                                state = draggableState,
                                orientation = Orientation.Horizontal,
                                onDragStopped = {
                                    onDragStopped(velocity = it)
                                }
                            )
                    )
                }

                AppNavHost(
                    modifier = Modifier
                        .alpha(
                            alpha = 1 - 0.5f * (translationX.value / drawerWidth).coerceIn(
                                0f,
                                1f
                            )
                        )
                        .padding(paddingValues = it)
                        .graphicsLayer { this.translationX = translationX.value }
                        .draggable(enabled = isDragEnabled,
                            state = draggableState,
                            orientation = Orientation.Horizontal,
                            onDragStopped = { onDragStopped(velocity = it) }),
                    toggleDrawer = { toggleDrawer() },
                    navController = navController,
                    homeViewModel = homeViewModel
                )
            }
        }
    }
}

