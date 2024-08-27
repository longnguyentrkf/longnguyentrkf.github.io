package org.kingfu.portfolio.settings.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.kingfu.portfolio.ui.theme.ThemeType

class SettingsViewModel: ViewModel() {
    var state by mutableStateOf(value = SettingsState())
        private set

    fun setTheme(theme: ThemeType){
        state = state.copy(theme = theme)
    }

    fun setIsShowDialogTheme(boolean: Boolean) {
        state = state.copy(isShowDialogTheme = boolean)
    }

}