package com.kingfuspace.main

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kingfuspace.main.core.Variables.fontSizeMultiplier
import com.kingfuspace.main.core.Variables.windowInnerWidth
import com.kingfuspace.main.core.Variables.windowWidth
import com.kingfuspace.main.home.viewModel.HomeViewModel
import com.kingfuspace.main.navigation.NavigationDrawer
import com.kingfuspace.main.ui.theme.KingFuTheme
import com.kingfuspace.main.ui.theme.TypographyPreview
import com.kingfuspace.main.ui.util.SetFontSizeMultiplier
import com.kingfuspace.main.ui.util.SetWindowInnerWidth
import kotlinx.browser.document
import kotlinx.browser.window


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        SetWindowInnerWidth()
        SetFontSizeMultiplier()
        KingFuTheme(content = { NavigationDrawer() })
    }
}



