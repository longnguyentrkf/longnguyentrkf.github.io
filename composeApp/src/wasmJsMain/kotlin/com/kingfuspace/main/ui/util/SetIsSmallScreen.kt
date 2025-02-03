package com.kingfuspace.main.ui.util

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import com.kingfuspace.main.core.SMALL_WINDOW
import com.kingfuspace.main.core.Variables.isSmallScreen
import com.kingfuspace.main.core.Variables.windowInnerWidth

@Composable
fun SetIsSmallScreen() = BoxWithConstraints {
    isSmallScreen = windowInnerWidth < SMALL_WINDOW
}