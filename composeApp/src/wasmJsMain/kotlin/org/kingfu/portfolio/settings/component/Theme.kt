package org.kingfu.portfolio.settings.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Brightness4
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion.LongPress
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import com.kingfu.imaginate.ui.theme.TextBodyMedium
import org.kingfu.portfolio.ui.theme.ThemeType
import org.kingfu.portfolio.core.formatEnumName
import org.kingfu.portfolio.ui.component.MyDialog

@Composable
fun Theme(
    theme: ThemeType,
    setTheme: (ThemeType) -> Unit,
    isShowDialog: Boolean,
    setIsShowDialog: (Boolean) -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val choices = listOf(
        ThemeType.LIGHT to ThemeType.LIGHT.name.formatEnumName(),
        ThemeType.DARK to ThemeType.DARK.name.formatEnumName()
    )

    val title = "Theme"

    if (isShowDialog) {
        MyDialog(
            title = title,
            choices = choices,
            onDismiss = { setIsShowDialog(false) },
            onClick = {
                setIsShowDialog(false)
                haptic.performHapticFeedback(hapticFeedbackType = LongPress)
                setTheme(it)
            },
            selectedItem = theme
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                haptic.performHapticFeedback(hapticFeedbackType = LongPress)
                setIsShowDialog(true)
            }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.padding(all = 16.dp),
            imageVector = Icons.Outlined.Brightness4,
            contentDescription = null
        )

        Column {
            TextBodyLarge(text = title)

            TextBodyMedium(
                text = choices.first { it.first == theme }.second,
                color = colorScheme.outline
            )
        }
    }
}

