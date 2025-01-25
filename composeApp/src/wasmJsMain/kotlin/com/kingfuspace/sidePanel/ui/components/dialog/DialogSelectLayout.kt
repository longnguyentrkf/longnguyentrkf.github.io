package com.kingfuspace.sidePanel.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kingfuspace.main.core.formatEnumName
import com.kingfuspace.main.editor.state.LayoutType
import com.kingfuspace.main.ui.theme.Typography
import kotlin.enums.EnumEntries

@Composable
fun DialogSelectLayout(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onConfirm: (LayoutType) -> Unit,
    options: EnumEntries<LayoutType>,
    defaultOption: LayoutType? = null
) {

    var selected: LayoutType? by remember { mutableStateOf(value = defaultOption) }

    Dialog(
        onDismissRequest = onDismiss,
        content = {
            Column(
                modifier = modifier
                    .background(
                        shape = Shapes().large,
                        color = colorScheme.surface
                    )
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 24.dp),
//                    text = "Choose a banner",
                    text = "Choose a layout",
                    style = Typography.bodySmall
                )

                options.forEachIndexed { _, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selected = item }
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selected == item,
                            onClick = { selected = item }
                        )

                        Text(
                            text = item.name.formatEnumName(),
                            style = Typography.labelMedium
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 24.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        enabled = selected != null && selected != defaultOption,
                        onClick = {
                            onConfirm(selected!!)
                            onDismiss()
                        }
                    ) {
                        Text(text = "Confirm", style = Typography.labelMedium)
                    }
                }
            }
        }
    )
}