package com.kingfuspace.main.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.core.theme.ThemeType
import kotlinx.browser.window

const val SMALL_WINDOW = 600

object Variables {
    var windowInnerWidth by mutableStateOf(value = window.innerWidth)
    val windowWidth = window.screen.width
    var theme by mutableStateOf(value = ThemeType.LIGHT)
    val fontSizeMultiplier = (windowInnerWidth.dp / windowWidth.dp)
        .coerceIn(minimumValue = 0.5f, maximumValue = 1f)
}