package space.kingfu.webpage.flow.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.ButtonData
import space.kingfu.webpage.ui.components.MyBody
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun FlowButtonHeader(
    modifier: Modifier = Modifier,
    removeButton: (index: Int) -> Unit,
    addButton: () -> Unit,
    setButtons: (buttonIndex: Int, buttonData: ButtonData) -> Unit,
    buttons: List<ButtonData>
) {
    Row(
        modifier = modifier.horizontalScroll(state = rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        buttons.forEachIndexed { index, button ->
            if (button.isEdit) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTextField(
                        modifier = Modifier
                            .width(width = 120.dp)
                            .clip(shape = CircleShape)
                            .background(color = colorScheme.surfaceContainer)
                            .border(
                                width = 1.dp,
                                color = colorScheme.inverseSurface,
                                shape = CircleShape
                            )
                            .padding(start = 8.dp, end = 16.dp)
                            .height(height = 48.dp),
                        value = button.text,
                        placeholder = "button",
                        onValueChange = {
                            setButtons(
                                index,
                                ButtonData(
                                    text = it,
                                    isEdit = true,
                                    url = button.url
                                )
                            )
                        },
                        contentAlignment = Alignment.Center,
                        style = Typography.bodySmall,
                        textAlign = TextAlign.Center,
                        maxChar = 30,
                        isSingleLine = true
                    )

                    MyTextField(
                        modifier = Modifier
                            .width(width = 120.dp)
                            .clip(shape = Shape.small)
                            .background(color = colorScheme.surfaceContainer)
                            .height(height = 48.dp)
                            .padding(start = 8.dp, end = 16.dp),
                        value = button.url,
                        placeholder = "url",
                        onValueChange = {
                            setButtons(
                                index,
                                ButtonData(
                                    url = it,
                                    isEdit = true,
                                    text = button.text
                                )
                            )
                        },
                        style = Typography.bodySmall,
                        isSingleLine = true,
                        contentAlignment = Alignment.Center,
                        textAlign = TextAlign.Center,
                        maxChar = 500
                    )

                    Row {
                        IconButton(
                            onClick = { removeButton(index) }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Remove,
                                contentDescription = null,
                                tint = colorScheme.error
                            )
                        }

                        IconButton(
                            onClick = {
                                setButtons(
                                    index,
                                    ButtonData(
                                        text = button.text,
                                        isEdit = false,
                                        url = button.url
                                    )
                                )
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Done,
                                contentDescription = null,
                            )
                        }
                    }
                }
            } else {
                OutlinedButton(
                    modifier = Modifier
                        .widthIn(min = 120.dp)
                        .height(height = 48.dp),
                    onClick = {
                        setButtons(
                            index,
                            ButtonData(
                                text = button.text,
                                isEdit = true,
                                url = button.url
                            )
                        )
                    }
                ) {
                    MyBody(
                        modifier = Modifier
                            .background(
                                color = if (button.text.isBlank()) colorScheme.surfaceContainer else Transparent,
                                shape = Shape.extraSmall
                            ),
                        body = button.text,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        if (buttons.size < 2) {
            IconButton(
                onClick = { addButton() }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        }
    }
}