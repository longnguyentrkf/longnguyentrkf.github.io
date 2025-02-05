package com.kingfuspace.main.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    label: String? = null,
//    labelIconOnClick: @Composable (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit,
    maxLines: Int = Int.MAX_VALUE,
    isSingleLine: Boolean = false,
    isEnabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
//    labelMaxLines: Int = Int.MAX_VALUE,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null
) {

    TextField(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Transparent,
            unfocusedContainerColor = Transparent,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            disabledPrefixColor = Transparent,
            disabledSuffixColor = Transparent,
            disabledSupportingTextColor = Transparent,
            disabledContainerColor = Transparent,
            disabledIndicatorColor = Transparent,
            disabledPlaceholderColor = Transparent,
            disabledLeadingIconColor = Transparent,
            disabledTrailingIconColor = Transparent
        ),
        textStyle = MaterialTheme.typography.bodyLarge,
        label = if (label != null) {
            {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
                    Text(
//                        modifier = Modifier.weight(weight = 1f),
                        text = label,
//                        style = MaterialTheme.typography.bodySmall,
//                        maxLines = labelMaxLines,
//                        overflow = TextOverflow.Ellipsis
                    )

//                    if (labelIconOnClick != null) {
//                        labelIconOnClick()
//                    }
//                }
            }
        } else null,
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLines,
        singleLine = isSingleLine,
        enabled = isEnabled,
        leadingIcon = if (leadingIcon != null) {
            { leadingIcon() }
        } else null,
        trailingIcon = if (trailingIcon != null) {
            { trailingIcon() }
        } else null,
        supportingText = if (supportingText != null) {
            { supportingText() }
        } else null,
        readOnly = readOnly,
        placeholder = placeholder
    )


}
