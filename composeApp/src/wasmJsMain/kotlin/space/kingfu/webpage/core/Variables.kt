package space.kingfu.webpage.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.ui.theme.ThemeType

object Variables {
    var maxWidth: Dp by mutableStateOf(value = 0.dp)
    var theme: ThemeType by mutableStateOf(value = ThemeType.LIGHT)
}

