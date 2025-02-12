package com.kingfuspace.sidePanel.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kingfuspace.main.ui.components.TextFieldWithErrorState

@Composable
fun DialogEditText(
    modifier: Modifier = Modifier,
    title: String,
    textValue: String,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
) {
    var editTextValue by rememberSaveable { mutableStateOf(value = textValue) }
    var isError by rememberSaveable { mutableStateOf(value = false) }
    val charLimit = 100

    Dialog(
        onDismissRequest = onDismiss,
        content = {
            Column(
                modifier = modifier
                    .clip(shape = shapes.medium)
                    .verticalScroll(state = rememberScrollState())
                    .background(color = MaterialTheme.colorScheme.surface)
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.spacedBy(space = 16.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                )

                TextFieldWithErrorState(
                    modifier = Modifier.fillMaxWidth(),
                    value = editTextValue,
                    label = "Name",
                    onValueChange = {
                        isError = it.length > charLimit
                        editTextValue = it
                    },
                    isError = isError,
                    charLimit = charLimit
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        enabled = editTextValue.isNotBlank() && !isError,
                        onClick = {
                            onConfirm(editTextValue)
                            onDismiss()
                        }
                    ) {
                        Text(
                            text = "Confirm",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
            }
        }
    )
}