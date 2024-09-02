package org.kingfu.portfolio.home.viewModel

import org.kingfu.portfolio.ui.theme.ThemeType

data class HomeState(
    val theme: ThemeType = ThemeType.DARK,
    val firstName: String = "",
    val lastName: String = "",
    val message: String = ""
)