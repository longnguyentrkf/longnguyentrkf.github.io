package com.kingfuspace.main.ui.util

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import com.kingfuspace.core.Variables.fontSizeMultiplier
import com.kingfuspace.core.Variables.windowWidth


@Composable
fun SetFontSizeMultiplier() = BoxWithConstraints {
    fontSizeMultiplier = (maxWidth.value / windowWidth).coerceIn(minimumValue = 0.5f, maximumValue = 1f)
}