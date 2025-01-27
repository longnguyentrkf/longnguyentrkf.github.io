package com.kingfuspace.main.ui.util

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.core.Variables.fontSizeMultiplier
import com.kingfuspace.main.core.Variables.windowInnerWidth
import com.kingfuspace.main.core.Variables.windowWidth
import kotlin.math.log10


@Composable
fun SetFontSizeMultiplier() = BoxWithConstraints {
    fontSizeMultiplier = (maxWidth.value / windowWidth).coerceIn(minimumValue = 0.5f, maximumValue = 1f)
//    fontSizeMultiplier = log10((windowInnerWidth.dp.value + 10).coerceIn(1f, 1000f)) /3
}