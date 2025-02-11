package com.kingfuspace.main.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    label: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    maxLines: Int = Int.MAX_VALUE,
    isSingleLine: Boolean = false,
    isEnabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    labelMaxLines: Int = Int.MAX_VALUE,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null
) {
    TextField(
        modifier = modifier,
        shape = MaterialTheme.shapes.extraSmall,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            disabledIndicatorColor = Transparent
        ),
        textStyle = MaterialTheme.typography.bodyLarge,
        label = if (label != null) { { Text(text = label, maxLines = labelMaxLines) } } else null,
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLines,
        singleLine = isSingleLine,
        enabled = isEnabled,
        leadingIcon = if (leadingIcon != null) { { leadingIcon() } } else null,
        trailingIcon = if (trailingIcon != null) { { trailingIcon() } } else null,
        supportingText = if (supportingText != null) { { supportingText() } } else null,
        readOnly = readOnly,
        placeholder = placeholder
    )


}
