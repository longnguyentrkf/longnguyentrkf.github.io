package space.kingfu.webpage.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import space.kingfu.webpage.flow.model.FlowSection
import space.kingfu.webpage.flow.model.FlowStyleData
import space.kingfu.webpage.flow.util.FlowSectionType
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.templates.components.MyBody
import space.kingfu.webpage.templates.components.MyFooter
import space.kingfu.webpage.templates.components.MyImage
import space.kingfu.webpage.templates.components.MySubtitle
import space.kingfu.webpage.templates.components.MyTitle
import space.kingfu.webpage.templates.components.TwoColumnLayout
import space.kingfu.webpage.topBar.BackTopBar
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowScreen(
    details: List<FlowSection>,
    setStyle: (FlowStyleData) -> Unit,
    addDetails: () -> Unit,
    goToTemplate: () -> Unit,
    removeButton: (index: Int, buttonIndex: Int) -> Unit,
    addButton: (indexSection: Int) -> Unit
) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current


    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    Scaffold(
        topBar = {
            BackTopBar(
                navigationIconOnClick = goToTemplate,
                name = Screen.Flow.name,
            )
        }
    ) { paddingValues ->


        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth().padding(paddingValues = paddingValues),
            contentAlignment = Alignment.Center
        ) {
            val width = maxWidth

            Column(
                modifier = Modifier
                    .verticalScroll(state = scrollState)
                    .widthIn(max = 1200.dp),
                verticalArrangement = Arrangement.spacedBy(space = 64.dp)
            ) {

                details.forEachIndexed { index, flowSection ->
                    TwoColumnLayout(
                        isReverseLayout = index % 2 != 0,
                        width = width,
                        left = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                if (flowSection.image.isEdit) {
                                    MyTextField(
                                        modifier = Modifier
                                            .zIndex(zIndex = 1f)
                                            .width(width = 350.dp)
                                            .height(height = 40.dp),
                                        value = flowSection.image.imageUrl ?: "",
                                        placeholder = "url",
                                        onValueChange = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.IMAGE,
                                                imageUrl = it
                                            )
                                            setStyle(data)
                                        },
                                        contentAlignment = Alignment.Center,
                                        style = Typography.bodySmall,
                                        textAlign = TextAlign.Center,
                                        maxChar = 500,
                                        isSingleLine = true,
                                        maxLine = 1,
                                        done = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.IMAGE,
                                                isEdit = false,
                                                imageUrl = flowSection.image.imageUrl
                                            )
                                            setStyle(data)
                                        },
                                        weight = 0.85f
                                    )
                                }

                                MyImage(
                                    modifier = Modifier
                                        .clip(shape = Shape.medium)
                                        .background(
                                            if (flowSection.image.imageUrl != null) {
                                                Transparent
                                            } else {
                                                colorScheme.surfaceContainer.copy(alpha = 0.5f)
                                            }
                                        )
                                        .clickable(enabled = !flowSection.image.isEdit) {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.IMAGE,
                                                isEdit = true,
                                                imageUrl = flowSection.image.imageUrl
                                            )
                                            setStyle(data)
                                        },
                                    url = flowSection.image.imageUrl,
                                )
                            }
                        },
                        right = {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                if (flowSection.title.isEdit) {
                                    MyTextField(
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        value = flowSection.title.text,
                                        placeholder = "title",
                                        onValueChange = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.TITLE,
                                                text = it
                                            )
                                            setStyle(data)

                                        },
                                        contentAlignment = Alignment.Center,
                                        style = Typography.bodyLarge,
                                        fontWeight = FontWeight.Bold,
                                        done = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.TITLE,
                                                isEdit = false
                                            )
                                            setStyle(data)
                                        },
                                        textAlign = TextAlign.Center
                                    )
                                } else {
                                    MyTitle(
                                        modifier = Modifier
                                            .padding(vertical = if (flowSection.title.text.isBlank()) 4.dp else 0.dp)
                                            .clickable {
                                                val data = FlowStyleData(
                                                    index = index,
                                                    section = FlowSectionType.TITLE,
                                                    isEdit = true
                                                )
                                                setStyle(data)
                                            }
                                            .background(
                                                if (flowSection.title.text.isBlank()) colorScheme.inverseSurface.copy(
                                                    alpha = 0.05f
                                                ) else Transparent
                                            ),
                                        title = flowSection.title.text
                                    )
                                }

                                if (flowSection.subtitle.isEdit) {
                                    MyTextField(
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        value = flowSection.subtitle.text,
                                        placeholder = "subtitle",
                                        onValueChange = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.SUBTITLE,
                                                text = it
                                            )
                                            setStyle(data)
                                        },
                                        contentAlignment = Alignment.Center,
                                        style = Typography.bodySmall,
                                        done = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.SUBTITLE,
                                                isEdit = false
                                            )
                                            setStyle(data)
                                        },
                                        textAlign = TextAlign.Center,
                                        fontStyle = FontStyle.Italic
                                    )
                                } else {
                                    MySubtitle(
                                        modifier = Modifier
                                            .padding(vertical = if (flowSection.subtitle.text.isBlank()) 4.dp else 0.dp)
                                            .clickable {
                                                val data = FlowStyleData(
                                                    index = index,
                                                    section = FlowSectionType.SUBTITLE,
                                                    isEdit = true
                                                )
                                                setStyle(data)
                                            }
                                            .background(
                                                if (flowSection.subtitle.text.isBlank()) colorScheme.inverseSurface.copy(
                                                    alpha = 0.05f
                                                ) else Transparent
                                            ),
                                        subtitle = flowSection.subtitle.text
                                    )
                                }

                                if (flowSection.body.isEdit) {
                                    MyTextField(
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        value = flowSection.body.text,
                                        placeholder = "body",
                                        onValueChange = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.BODY,
                                                text = it
                                            )
                                            setStyle(data)
                                        },
                                        contentAlignment = Alignment.TopStart,
                                        style = Typography.bodySmall,
                                        done = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.BODY,
                                                isEdit = false
                                            )
                                            setStyle(data)
                                        },
                                        textAlign = TextAlign.Justify,
                                        maxChar = 2000
                                    )
                                } else {
                                    MyBody(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = if (flowSection.body.text.isBlank()) 4.dp else 0.dp)
                                            .clickable {
                                                val data = FlowStyleData(
                                                    index = index,
                                                    section = FlowSectionType.BODY,
                                                    isEdit = true
                                                )
                                                setStyle(data)
                                            }
                                            .background(
                                                if (flowSection.body.text.isBlank()) colorScheme.inverseSurface.copy(
                                                    alpha = 0.05f
                                                ) else Transparent
                                            ),
                                        body = details[index].body.text
                                    )
                                }

                                if (flowSection.footer.isEdit) {
                                    MyTextField(
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        value = flowSection.footer.text,
                                        placeholder = "footer",
                                        onValueChange = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.FOOTER,
                                                text = it
                                            )
                                            setStyle(data)
                                        },
                                        contentAlignment = Alignment.TopStart,
                                        style = Typography.bodySmall,
                                        done = {
                                            val data = FlowStyleData(
                                                index = index,
                                                section = FlowSectionType.FOOTER,
                                                isEdit = false
                                            )
                                            setStyle(data)
                                        },
                                        textAlign = TextAlign.Justify,
                                        maxChar = 200,
                                        placeHolderColor = colorScheme.outline.copy(alpha = 0.5f),
                                        editTextColor = colorScheme.outline
                                    )
                                } else {
                                    MyFooter(
                                        modifier = Modifier
                                            .padding(vertical = if (flowSection.footer.text.isBlank()) 4.dp else 0.dp)
                                            .clickable {
                                                val data = FlowStyleData(
                                                    index = index,
                                                    section = FlowSectionType.FOOTER,
                                                    isEdit = true
                                                )
                                                setStyle(data)
                                            }
                                            .background(
                                                if (flowSection.footer.text.isBlank()) colorScheme.inverseSurface.copy(
                                                    alpha = 0.05f
                                                ) else Transparent
                                            ),
                                        footer = details[index].footer.text,
                                        textAlign = TextAlign.Justify
                                    )
                                }

                                Row(
                                    modifier = Modifier.horizontalScroll(state = rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(space = 12.dp)
                                ) {
                                    flowSection.buttons.forEachIndexed { buttonIndex, flowButton ->
                                        if (flowButton.isEdit) {
                                            Column(
                                                verticalArrangement = Arrangement.spacedBy(space = 16.dp),
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                MyTextField(
                                                    modifier = Modifier.width(width = 200.dp),
                                                    value = flowButton.text,
                                                    placeholder = "button",
                                                    onValueChange = {
                                                        val data = FlowStyleData(
                                                            index = index,
                                                            section = FlowSectionType.BUTTONS,
                                                            text = it,
                                                            buttonIndex = buttonIndex,
                                                            buttonUrl = flowButton.buttonUrl
                                                        )
                                                        setStyle(data)
                                                    },
                                                    contentAlignment = Alignment.Center,
                                                    style = Typography.bodySmall,
                                                    done = {
                                                        val data = FlowStyleData(
                                                            index = index,
                                                            section = FlowSectionType.BUTTONS,
                                                            isEdit = false,
                                                            buttonIndex = buttonIndex,
                                                            buttonUrl = flowButton.buttonUrl
                                                        )
                                                        setStyle(data)
                                                    },
                                                    textAlign = TextAlign.Center,
                                                    maxChar = 30,
                                                    borderColor = colorScheme.inverseSurface,
                                                    isSingleLine = true,
                                                    maxLine = 1,
                                                    weight = 0.75f
                                                )
                                                MyTextField(
                                                    modifier = Modifier
                                                        .clip(shape = CircleShape)
                                                        .width(width = 200.dp)
                                                        .height(height = 40.dp),
                                                    value = flowButton.buttonUrl
                                                        ?: "",
                                                    placeholder = "url",
                                                    onValueChange = {
                                                        val data = FlowStyleData(
                                                            index = index,
                                                            section = FlowSectionType.BUTTONS,
                                                            buttonIndex = buttonIndex,
                                                            buttonUrl = it
                                                        )
                                                        setStyle(data)
                                                    },
                                                    contentAlignment = Alignment.Center,
                                                    style = Typography.bodySmall,
                                                    textAlign = TextAlign.Center,
                                                    maxChar = 200,
                                                    isSingleLine = true,
                                                    maxLine = 1
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
                                                modifier = Modifier.widthIn(min = 100.dp),
                                                onClick = {
                                                    val data = FlowStyleData(
                                                        index = index,
                                                        section = FlowSectionType.BUTTONS,
                                                        isEdit = true,
                                                        buttonIndex = buttonIndex,
                                                        buttonUrl = flowButton.buttonUrl
                                                    )
                                                    setStyle(data)
                                                }
                                            ) {
                                                MyBody(
                                                    modifier = Modifier
                                                        .background(
                                                            if (flowButton.text.isBlank()) colorScheme.inverseSurface.copy(
                                                                alpha = 0.05f
                                                            ) else Transparent
                                                        ),
                                                    body = flowButton.text,
                                                    textAlign = TextAlign.Center,
                                                    maxLines = 1
                                                )
                                            }
                                        }
                                    }

                                    if(flowSection.buttons.size < 2) {
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

                        }
                    )
                }

                if (details.size < 5) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 300.dp)
                            .padding(horizontal = 24.dp)
                            .clip(shape = Shape.medium)
                            .background(colorScheme.surfaceContainer)
                            .clickable { addDetails() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                    }
                }

                Spacer(modifier = Modifier.height(height = 200.dp))

            }
        }
    }
}

