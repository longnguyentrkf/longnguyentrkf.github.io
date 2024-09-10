package space.kingfu.webpage.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.imaginate
import space.kingfu.webpage.flow.model.FlowSection
import space.kingfu.webpage.flow.util.FlowSectionType
import space.kingfu.webpage.flow.util.FlowStyle
import space.kingfu.webpage.templates.components.MyBody
import space.kingfu.webpage.templates.components.MyFooter
import space.kingfu.webpage.templates.components.MyImage
import space.kingfu.webpage.templates.components.MySpace
import space.kingfu.webpage.templates.components.MySubtitle
import space.kingfu.webpage.templates.components.MyTitle
import space.kingfu.webpage.templates.components.TwoColumnLayout
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun FlowScreen(
    details: List<FlowSection>,
    setSection: (index: Int, FlowSectionType, newValue: Any, buttonIndex: Int?, url: String?) -> Unit,
    setStyle: (index: Int, flowSectionType: FlowSectionType, flowStyle: FlowStyle, newValue: Any, buttonIndex: Int?, url: String?) -> Unit,
    addDetails: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val width = maxWidth

        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .widthIn(max = 1200.dp),
            verticalArrangement = Arrangement.spacedBy(space = 64.dp)
        ) {

            TwoColumnLayout(
                isSmallScreenReverseLayout = true,
                width = width,
                left = {
                    if (details[0].title.isEdit) {
                        MyTextField(
                            modifier = Modifier.padding(vertical = 4.dp),
                            value = details[0].title.text,
                            placeholder = "title",
                            onValueChange = { setSection(0, FlowSectionType.TITLE, it, null, null) },
                            contentAlignment = Alignment.Center,
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            done = {
                                setStyle(
                                    0,
                                    FlowSectionType.TITLE,
                                    FlowStyle.IS_EDIT,
                                    false,
                                    null,
                                    null
                                )
                            },
                            textAlign = TextAlign.Center
                        )
                    } else {
                        MyTitle(
                            modifier = Modifier
                                .padding(vertical = if (details[0].title.text.isBlank()) 4.dp else 0.dp)
                                .clickable {
                                    setStyle(
                                        0,
                                        FlowSectionType.TITLE,
                                        FlowStyle.IS_EDIT,
                                        true,
                                        null,
                                        null
                                    )
                                }
                                .background(
                                    if (details[0].title.text.isBlank()) colorScheme.inverseSurface.copy(
                                        alpha = 0.05f
                                    ) else Transparent
                                ),
                            title = details[0].title.text
                        )
                    }

                    if (details[0].subtitle.isEdit) {
                        MyTextField(
                            modifier = Modifier.padding(vertical = 4.dp),
                            value = details[0].subtitle.text,
                            placeholder = "subtitle",
                            onValueChange = { setSection(0, FlowSectionType.SUBTITLE, it, null, null) },
                            contentAlignment = Alignment.Center,
                            style = Typography.bodySmall,
                            done = {
                                setStyle(
                                    0,
                                    FlowSectionType.SUBTITLE,
                                    FlowStyle.IS_EDIT,
                                    false,
                                    null,
                                    null
                                )
                            },
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Italic
                        )
                    } else {
                        MySubtitle(
                            modifier = Modifier
                                .padding(vertical = if (details[0].subtitle.text.isBlank()) 4.dp else 0.dp)
                                .clickable {
                                    setStyle(
                                        0,
                                        FlowSectionType.SUBTITLE,
                                        FlowStyle.IS_EDIT,
                                        true,
                                        null,
                                        null
                                    )
                                }
                                .background(
                                    if (details[0].subtitle.text.isBlank()) colorScheme.inverseSurface.copy(
                                        alpha = 0.05f
                                    ) else Transparent
                                ),
                            subtitle = details[0].subtitle.text
                        )
                    }

                    MySpace()

                    if (details[0].body.isEdit) {
                        MyTextField(
                            modifier = Modifier.padding(vertical = 4.dp),
                            value = details[0].body.text,
                            placeholder = "body",
                            onValueChange = { setSection(0, FlowSectionType.BODY, it, null, null) },
                            contentAlignment = Alignment.TopStart,
                            style = Typography.bodySmall,
                            done = {
                                setStyle(
                                    0,
                                    FlowSectionType.BODY,
                                    FlowStyle.IS_EDIT,
                                    false,
                                    null,
                                    null
                                )
                            },
                            textAlign = TextAlign.Justify,
                            maxChar = 2000
                        )
                    } else {
                        MyBody(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = if (details[0].body.text.isBlank()) 4.dp else 0.dp)
                                .clickable {
                                    setStyle(
                                        0,
                                        FlowSectionType.BODY,
                                        FlowStyle.IS_EDIT,
                                        true,
                                        null,
                                        null
                                    )
                                }
                                .background(
                                    if (details[0].body.text.isBlank()) colorScheme.inverseSurface.copy(
                                        alpha = 0.05f
                                    ) else Transparent
                                ),
                            body = details[0].body.text
                        )
                    }

                    MySpace()

                    if (details[0].footer.isEdit) {
                        MyTextField(
                            modifier = Modifier.padding(vertical = 4.dp),
                            value = details[0].footer.text,
                            placeholder = "footer",
                            onValueChange = { setSection(0, FlowSectionType.FOOTER, it, null, null) },
                            contentAlignment = Alignment.TopStart,
                            style = Typography.bodySmall,
                            done = {
                                setStyle(
                                    0,
                                    FlowSectionType.FOOTER,
                                    FlowStyle.IS_EDIT,
                                    false,
                                    null,
                                    null
                                )
                            },
                            textAlign = TextAlign.Justify,
                            maxChar = 200,
                            placeHolderColor = colorScheme.outline.copy(alpha = 0.5f),
                            editTextColor = colorScheme.outline
                        )
                    } else {
                        MyFooter(
                            modifier = Modifier
                                .padding(vertical = if (details[0].footer.text.isBlank()) 4.dp else 0.dp)
                                .clickable {
                                    setStyle(
                                        0,
                                        FlowSectionType.FOOTER,
                                        FlowStyle.IS_EDIT,
                                        true,
                                        null,
                                        null
                                    )
                                }
                                .background(
                                    if (details[0].footer.text.isBlank()) colorScheme.inverseSurface.copy(
                                        alpha = 0.05f
                                    ) else Transparent
                                ),
                            footer = details[0].footer.text,
                            textAlign = TextAlign.Justify
                        )
                    }

                    MySpace()


                    if (details[0].buttons[0].isEdit) {
                        Column(verticalArrangement = Arrangement.spacedBy(space = 16.dp)) {
                            MyTextField(
                                modifier = Modifier.width(width = 200.dp),
                                value = details[0].buttons[0].text,
                                placeholder = "button",
                                onValueChange = {
                                    setSection(
                                        0,
                                        FlowSectionType.BUTTONS,
                                        it,
                                        0,
                                        null
                                    )
                                },
                                contentAlignment = Alignment.Center,
                                style = Typography.bodySmall,
                                done = {
                                    setStyle(
                                        0,
                                        FlowSectionType.BUTTONS,
                                        FlowStyle.IS_EDIT,
                                        false,
                                        0,
                                        details[0].buttons[0].url
                                    )
                                },
                                textAlign = TextAlign.Center,
                                maxChar = 30,
                                borderColor = colorScheme.inverseSurface,
                                isSingleLine = true,
                                maxLine = 1,
                                weight = 0.3f
                            )
                            MyTextField(

                                modifier = Modifier.width(width = 200.dp).height(height = 40.dp),
                                value = details[0].buttons[0].url,
                                placeholder = "url",
                                onValueChange = {
                                    setSection(
                                        0,
                                        FlowSectionType.BUTTONS,
                                        it,
                                        0,
                                        it
                                    )
                                },
                                contentAlignment = Alignment.Center,
                                style = Typography.bodySmall,
                                textAlign = TextAlign.Center,
                                maxChar = 200,
                                isSingleLine = true,
                                maxLine = 1,
                            )
                        }

                    } else {

                        OutlinedButton(
                            modifier = Modifier.widthIn(min = 100.dp),
                            onClick = {
                                setStyle(
                                    0,
                                    FlowSectionType.BUTTONS,
                                    FlowStyle.IS_EDIT,
                                    true,
                                    0,
                                    details[0].buttons[0].url
                                )
                            }
                        ) {
                            MyBody(
                                modifier = Modifier
                                    .background(
                                        if (details[0].buttons[0].text.isBlank()) colorScheme.inverseSurface.copy(
                                            alpha = 0.05f
                                        ) else Transparent
                                    ),
                                body = details[0].buttons[0].text,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )
                        }
                    }
                },
                right = {
                    MyImage(
                        modifier = Modifier.clickable {
                            uriHandler.openUri(uri = details[0].buttons[0].url)
                        },
                        resource = Res.drawable.imaginate
                    )
                }
            )

        }
    }

}