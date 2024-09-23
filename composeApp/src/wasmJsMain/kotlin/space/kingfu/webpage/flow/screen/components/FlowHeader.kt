package space.kingfu.webpage.flow.screen.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.core.Variables.maxWidth
import space.kingfu.webpage.flow.ui.FlowButton
import space.kingfu.webpage.flow.ui.FlowImage
import space.kingfu.webpage.flow.ui.FlowText
import space.kingfu.webpage.flow.viewModel.ButtonData
import space.kingfu.webpage.flow.viewModel.Header
import space.kingfu.webpage.flow.viewModel.ImageData
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.components.TwoColumnLayout
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun FlowHeader(
    modifier: Modifier = Modifier,
    header: Header,
    setImageHeader: (ImageData) -> Unit,
    setHeaderTitle1: (TextData) -> Unit,
    setHeaderTitle2: (TextData) -> Unit,
    setButtonsHeader: (Int, ButtonData) -> Unit,
    removeButtonHeader: (Int) -> Unit,
    addButtonHeader: () -> Unit
) {
    TwoColumnLayout(
        modifier = modifier,
        width = maxWidth,
        left = {
            FlowImage(
                height = 1.dp,
                width = 1.dp,
                image = header.image,
                onClick = {
                    setImageHeader(
                        ImageData(
                            isEdit = !header.image.isEdit,
                            url = header.image.url
                        )
                    )
                },
                onValueChange = {
                    setImageHeader(
                        ImageData(
                            isEdit = true,
                            url = it
                        )
                    )
                }
            )
        },
        right = {
            FlowText(
                text = header.headerTitle1.text,
                placeholder = "title 1",
                onValueChange = { setHeaderTitle1(TextData(isEdit = true, text = it)) },
                done = {
                    setHeaderTitle1(
                        TextData(
                            isEdit = false,
                            text = header.headerTitle1.text
                        )
                    )
                },
                clickable = {
                    setHeaderTitle1(
                        TextData(
                            isEdit = true,
                            text = header.headerTitle1.text
                        )
                    )
                },
                textAlign = TextAlign.Start,
                contentAlignment = Alignment.TopStart,
                isEdit = header.headerTitle1.isEdit,
                style = Typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(height = 12.dp))

            FlowText(
                text = header.headerTitle2.text,
                placeholder = "title 2",
                onValueChange = { setHeaderTitle2(TextData(isEdit = true, text = it)) },
                done = {
                    setHeaderTitle2(
                        TextData(
                            isEdit = false,
                            text = header.headerTitle2.text
                        )
                    )
                },
                clickable = {
                    setHeaderTitle2(
                        TextData(
                            isEdit = true,
                            text = header.headerTitle2.text
                        )
                    )
                },
                textAlign = TextAlign.Start,
                contentAlignment = Alignment.TopStart,
                isEdit = header.headerTitle2.isEdit,
                style = Typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(height = 12.dp))

            Row(
                modifier = Modifier.horizontalScroll(state = rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                header.buttons.forEachIndexed { buttonIndex, buttonData ->
                    FlowButton(
                        buttonData = buttonData,
                        done = {
                            setButtonsHeader(
                                buttonIndex,
                                ButtonData(
                                    text = buttonData.text,
                                    isEdit = false,
                                    url = buttonData.url
                                )
                            )
                        },
                        onValueChangeButton = {
                            setButtonsHeader(
                                buttonIndex,
                                ButtonData(
                                    text = it,
                                    isEdit = true,
                                    url = buttonData.url
                                )
                            )
                        },
                        onValueChangeUrl = {
                            setButtonsHeader(
                                buttonIndex,
                                ButtonData(
                                    url = it,
                                    isEdit = true,
                                    text = buttonData.text
                                )
                            )
                        },
                        remove = { removeButtonHeader(buttonIndex) },
                        onClick = {
                            setButtonsHeader(
                                buttonIndex,
                                ButtonData(
                                    text = buttonData.text,
                                    isEdit = true,
                                    url = buttonData.url
                                )
                            )
                        }
                    )
                }

                if (header.buttons.size < 2) {
                    IconButton(onClick = addButtonHeader) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}