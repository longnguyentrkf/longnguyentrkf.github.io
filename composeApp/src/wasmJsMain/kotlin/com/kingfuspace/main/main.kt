package com.kingfuspace.main

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.window.ComposeViewport
import com.kingfuspace.core.Variables.theme
import com.kingfuspace.core.theme.ThemeType
import com.kingfuspace.main.navigation.NavigationDrawer
import com.kingfuspace.main.ui.theme.KingFuTheme
import com.kingfuspace.main.ui.util.SetFontSizeMultiplier
import com.kingfuspace.main.ui.util.SetIsSmallScreen
import com.kingfuspace.main.ui.util.SetWindowInnerHeight
import com.kingfuspace.main.ui.util.SetWindowInnerWidth
import kotlinx.browser.document
import org.w3c.dom.HTMLStyleElement

fun updateBodyBackground(theme: ThemeType) {
    val styleElement = document.getElementById("dynamic-theme-style") as? HTMLStyleElement
        ?: (document.createElement("style") as HTMLStyleElement).apply {
            id = "dynamic-theme-style"
            document.head!!.appendChild(this)
        }

    styleElement.innerHTML = """
        body {
            background-color: ${if (theme == ThemeType.LIGHT) "#FFFFFF" else "#000000"};
        }
    """.trimIndent()
}


@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    ComposeViewport(document.body!!) {
        updateBodyBackground(theme = theme)
        SetWindowInnerWidth()
        SetWindowInnerHeight()
        SetFontSizeMultiplier()
        SetIsSmallScreen()

        KingFuTheme(
            content = {
                NavigationDrawer()
            }
        )
    }
}



