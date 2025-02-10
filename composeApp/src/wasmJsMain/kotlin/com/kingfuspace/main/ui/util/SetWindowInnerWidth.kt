package com.kingfuspace.main.ui.util

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import com.kingfuspace.core.Variables.windowInnerWidth

@Composable
fun SetWindowInnerWidth() = BoxWithConstraints {
    windowInnerWidth = maxWidth.value.toInt()
}
