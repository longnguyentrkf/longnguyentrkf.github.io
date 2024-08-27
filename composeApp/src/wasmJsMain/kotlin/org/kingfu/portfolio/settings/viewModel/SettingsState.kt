package org.kingfu.portfolio.settings.viewModel

import org.kingfu.portfolio.ui.theme.ThemeType

data class SettingsState(
    val theme: ThemeType = ThemeType.LIGHT,
    val isShowDialogTheme: Boolean = false
)