package space.kingfu.webpage.core

import space.kingfu.webpage.core.Variables.theme
import space.kingfu.webpage.ui.theme.ThemeType

fun setTheme(themeType: ThemeType) {
    theme = if(themeType == ThemeType.DARK) ThemeType.LIGHT else ThemeType.DARK
}