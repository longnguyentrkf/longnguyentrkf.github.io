package com.kingfuspace.sidePanel.ui.components.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kingfuspace.main.ui.theme.Typography

@Composable
fun DialogEditText(
    modifier: Modifier = Modifier,
    title: String,
    textValue: String,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
) {
    var editTextValue by remember { mutableStateOf(value = textValue) }

    AlertDialog(
        modifier = modifier,
        containerColor = colorScheme.surface,
        title = { Text(text = title, style = Typography.bodyMedium) },
        text = {
            TextField(
                value = editTextValue,
                onValueChange = { editTextValue = it },
                textStyle = Typography.bodySmall
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                enabled = editTextValue.isNotBlank(),
                onClick = {
                    onConfirm(editTextValue)
                    onDismiss()
                }
            ) {
                Text(text = "Confirm", style = Typography.bodySmall)
            }
        }
    )
}