package com.kingfuspace.sidePanel.ui.components.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kingfuspace.main.ui.theme.Typography

@Composable
fun DialogConfirm(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    text: String,
    title: String,
    titleColor: Color = colorScheme.error
) {
    AlertDialog(
        modifier = modifier,
        containerColor = colorScheme.surface,
        title = { Text(text = title, color = titleColor) },
        text = { Text(text = text, style = Typography.bodySmall) },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                    onDismiss()
                }
            ) {
                Text(text = "Confirm", style = Typography.bodySmall)
            }
        }
    )
}