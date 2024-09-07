package space.kingfu.webpage.home.viewModel

import space.kingfu.webpage.ui.theme.ThemeType


data class HomeState(
    val theme: ThemeType = ThemeType.LIGHT,
    val firstName: String = "",
    val lastName: String = "",
    val message: String = ""
)