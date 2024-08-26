package org.kingfu.portfolio.navigation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun NavigationDrawer() {
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
    val screens = listOf(Screen.Home, Screen.Settings)
    val isDrawerOpen = drawerState == DrawerValue.Open

    fun toggleDrawer() {
        scope.launch {
            translationX.animateTo(targetValue = if (isDrawerOpen) 0f else drawerWidth)
            drawerState = if (isDrawerOpen) DrawerValue.Closed else DrawerValue.Open
        }
    }



    fun onDragStopped(velocity: Float) {
        val decayX = decay.calculateTargetValue(
            translationX.value,
            velocity
        )

        scope.launch {
            val targetX = if (decayX > drawerWidth * 0.5) drawerWidth else 0f
            val canReachTargetWithDecay = (decayX > targetX && targetX == drawerWidth) ||
                    (decayX < targetX && targetX == 0f)

            if (canReachTargetWithDecay) {
                translationX.animateDecay(initialVelocity = velocity, animationSpec = decay)
            } else {
                translationX.animateTo(targetValue = targetX, initialVelocity = velocity)
            }

            drawerState = if (targetX == drawerWidth) DrawerValue.Open else DrawerValue.Closed

        }
    }



    DrawerContent(
        navController = navController,
        toggleDrawer = ::toggleDrawer,
        route = route,
        modifier = Modifier
            .width(width = drawerWidth.dp)
            .graphicsLayer { this.translationX = -drawerWidth + translationX.value }
            .draggable(
                state = draggableState,
                orientation = Orientation.Horizontal,
                onDragStopped = { onDragStopped(velocity = it) }
            ),
        screens = screens
    )

    Box {
        if (translationX.value > 0f) {
            Box(
                modifier = Modifier
                    .zIndex(zIndex = 1f)
                    .matchParentSize()
                    .graphicsLayer { this.translationX = translationX.value }
                    .background(
                        color = colorScheme.surface.copy(
                            alpha = 0.5f * (translationX.value / drawerWidth).coerceIn(0f, 1f)
                        )
                    )
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { toggleDrawer() }
                    )
                    .draggable(
                        state = draggableState,
                        orientation = Orientation.Horizontal,
                        onDragStopped = { onDragStopped(velocity = it) }
                    )
            )
        }

        AppNavHost(
            modifier = Modifier
                .graphicsLayer { this.translationX = translationX.value }
                .draggable(
                    state = draggableState,
                    orientation = Orientation.Horizontal,
                    onDragStopped = { onDragStopped(velocity = it) }),
            toggleDrawer = { toggleDrawer() },
            navController = navController
        )
    }


}