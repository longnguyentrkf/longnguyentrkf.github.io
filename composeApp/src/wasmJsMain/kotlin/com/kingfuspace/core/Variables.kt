package com.kingfuspace.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.theme.ThemeType
import kotlinx.browser.window

const val SMALL_WINDOW = 600
const val MAIL_TO = "mailto:"
const val SUBJECT = "?subject="
const val BODY = "&body="

object Variables {
    var windowInnerWidth by mutableStateOf(value = window.innerWidth)
    var windowInnerHeight by mutableStateOf(value = window.innerHeight)
    val windowWidth = window.screen.width
    val windowHeight = window.screen.height
    var theme by mutableStateOf(value = ThemeType.DARK)
    var fontSizeMultiplier by mutableStateOf(
        value = (windowInnerWidth.dp / windowWidth.dp).coerceIn(
            minimumValue = 0.75f,
            maximumValue = 1f
        )
    )
    var isSmallScreen by mutableStateOf(value = windowInnerWidth < SMALL_WINDOW)
}