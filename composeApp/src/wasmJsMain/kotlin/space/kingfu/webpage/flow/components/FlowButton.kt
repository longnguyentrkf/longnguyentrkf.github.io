package space.kingfu.webpage.flow.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
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
fun FlowButton(
    modifier: Modifier = Modifier,
    index: Int,
    removeButton: (sectionIndex: Int, buttonIndex: Int) -> Unit,
//    removeButton: (buttonIndex: Int, buttons: MutableList<ButtonData>) -> Unit,
    addButton: (sectionIndex: Int) -> Unit,
    setButtons: (index: Int, buttonIndex: Int, buttonData: ButtonData) -> Unit,
    buttons: List<ButtonData>
) {
    Row(
        modifier = modifier.horizontalScroll(state = rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        buttons.forEachIndexed { buttonIndex, button ->
            if (button.isEdit) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(space = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTextField(
                        modifier = Modifier.width(width = 160.dp),
                        value = button.text,
                        placeholder = "button",
                        onValueChange = {
                            setButtons(
                                index,
                                buttonIndex,
                                ButtonData(
                                    text = it,
                                    isEdit = true,
                                    url = buttons[buttonIndex].url
                                )
                            )
                        },
                        contentAlignment = Alignment.Center,
                        style = Typography.bodySmall,
                        done = {
                            setButtons(
                                index,
                                buttonIndex,
                                ButtonData(
                                    text = button.text,
                                    isEdit = false,
                                    url = button.url
                                )
                            )
                        },
                        textAlign = TextAlign.Center,
                        maxChar = 30,
                        borderColor = colorScheme.inverseSurface,
                        isSingleLine = true,
                        weight = 0.75f
                    )
                    MyTextField(
                        modifier = Modifier
                            .clip(shape = Shape.medium)
                            .width(width = 160.dp)
                            .height(height = 42.dp),
                        value = button.url,
                        placeholder = "url",
                        onValueChange = {
                            setButtons(
                                index,
                                buttonIndex,
                                ButtonData(
                                    url = it,
                                    isEdit = true,
                                    text = buttons[buttonIndex].text
                                )
                            )
                        },
                        style = Typography.bodySmall,
                        isSingleLine = true,
                        contentAlignment = Alignment.Center,
                        textAlign = TextAlign.Center,
                        maxChar = 500
                    )

                    IconButton(
                        onClick = {
                            removeButton(
                                index,
                                buttonIndex
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = null,
                            tint = colorScheme.error
                        )
                    }
                }
            } else {
                OutlinedButton(
                    modifier = Modifier.widthIn(min = 80.dp),
                    onClick = {
                        setButtons(
                            index,
                            buttonIndex,
                            ButtonData(
                                text = buttons[buttonIndex].text,
                                isEdit = true,
                                url = buttons[buttonIndex].url
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
                onClick = { addButton(index) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    }
}