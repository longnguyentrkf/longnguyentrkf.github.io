package com.kingfuspace.main.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TextFieldWithErrorState(
    modifier: Modifier = Modifier,
    errorMessage: String = "Text input too long",
    charLimit: Int,
    value: String,
    label: String? = null,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    isSingleLine: Boolean = true

) {
//    var text by rememberSaveable { mutableStateOf(value = value) }
//    var isError by rememberSaveable { mutableStateOf(value = isError) }

//    fun validate(input: String) {
//        isError = input.length > charLimit
//    }

//    LaunchedEffect(key1 = value) { validate(input = value) }
//    LaunchedEffect(key1 = value) { value.checkStringLength(charLimit = charLimit) }

    TextField(
        modifier = modifier,
        textStyle = typography.bodySmall,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        singleLine = isSingleLine,
        label = if (label != null) {
            { Text(text = label, style = typography.labelLarge) }
        } else null,
        supportingText = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isError) {
                    Text(
                        text = errorMessage,
                        style = typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.weight(weight = 1f))

                Text(
                    text = "Limit: ${value.length}/$charLimit",
                    style = typography.bodySmall
                )
            }
        }
    )
}
