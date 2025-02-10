package com.kingfuspace.main.ui.util

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import com.kingfuspace.core.SMALL_WINDOW
import com.kingfuspace.core.Variables.isSmallScreen
import com.kingfuspace.core.Variables.windowInnerWidth

@Composable
fun SetIsSmallScreen() = BoxWithConstraints {
    isSmallScreen = windowInnerWidth < SMALL_WINDOW
}