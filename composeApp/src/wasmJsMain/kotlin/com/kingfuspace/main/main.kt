package com.kingfuspace.main

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key.Companion.Window
import androidx.compose.ui.window.ComposeViewport
import com.kingfuspace.main.navigation.NavigationDrawer
import com.kingfuspace.main.ui.theme.KingFuTheme
import com.kingfuspace.main.ui.util.SetFontSizeMultiplier
import com.kingfuspace.main.ui.util.SetIsSmallScreen
import com.kingfuspace.main.ui.util.SetWindowInnerHeight
import com.kingfuspace.main.ui.util.SetWindowInnerWidth
import kotlinx.browser.document
import kotlinx.browser.window


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {


        SetWindowInnerWidth()
        SetWindowInnerHeight()
        SetFontSizeMultiplier()
        SetIsSmallScreen()
        KingFuTheme(
            content = {
//            TypographyPreview()
                NavigationDrawer()
            }
        )
    }
}



