package com.kingfuspace.sidePanel.ui.components.dialog

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kingfuspace.main.editor.state.TextData

@Composable
fun DialogMoveTexts(
    modifier: Modifier = Modifier,
    texts: List<TextData>,
    onDismiss: () -> Unit,
    onSwap: (Int, Int) -> Unit,
    selectedIndex: Int,
    onMove: (Int, Int) -> Unit
) {

    var optionsIndex by remember { mutableStateOf(value = 1) }
    val options = listOf("Top", "Swap", "Bottom")

    val lazyRowState = rememberLazyListState()
    var targetIndex by remember { mutableStateOf(value = if (selectedIndex == 0) 1 else 0) }

    Dialog(
        onDismissRequest = onDismiss,
        content = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = colorScheme.surface)
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.spacedBy(space = 16.dp)
            ) {

                SingleChoiceSegmentedButtonRow {
                    options.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = options.size,
                                baseShape = AbsoluteRoundedCornerShape(percent = 0)
                            ),
                            onClick = { optionsIndex = index },
                            selected = index == optionsIndex,
                            label = { Text(text = label) },
                            icon = { },
                            colors = SegmentedButtonDefaults.colors(
                                activeContainerColor = colorScheme.inverseSurface,
                                activeContentColor = colorScheme.surface
                            )
                        )
                    }
                }


                Box {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        state = lazyRowState,
                        horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
                    ) {
                        items(count = texts.size) { index ->

                            Column(
                                modifier = Modifier
                                    .width(width = 150.dp)
                                    .background(color = colorScheme.surfaceContainer)
                                    .clickable(enabled = index != selectedIndex) { targetIndex = index }
                                    .alpha(alpha = if (index == targetIndex || index == selectedIndex) 1f else 0.5f)
                            ) {
                                Text(
                                    modifier = Modifier
                                        .height(height = 40.dp)
                                        .padding(all = 8.dp),
                                    text = texts[index].name,
                                    style = typography.labelLarge,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                )

                                Column(
                                    modifier = Modifier
                                        .size(size = 150.dp)
                                        .verticalScroll(state = rememberScrollState())
                                        .background(color = colorScheme.surfaceContainerLow)
                                ) {
                                    Text(
                                        text = texts[index].text,
                                        style = typography.bodySmall,
                                    )
                                }

                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 4.dp),
                                    text = when (index) {
                                        targetIndex -> "target"
                                        selectedIndex -> "selected"
                                        else -> ""
                                    },
                                    style = typography.bodySmall,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    HorizontalScrollbar(
                        modifier = Modifier.align(alignment = Alignment.BottomStart),
                        adapter = rememberScrollbarAdapter(scrollState = lazyRowState),
                        style = defaultScrollbarStyle().copy(
                            thickness = 12.dp,
                            unhoverColor = colorScheme.surfaceContainer,
                            hoverColor = colorScheme.surfaceContainer,
                            minimalHeight = 24.dp,
                            shape = CircleShape
                        )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorScheme.inverseSurface
                        ),
                        onClick = {
                            when (optionsIndex) {
                                0 -> {
                                    onMove(
                                        selectedIndex,
                                        if (selectedIndex < targetIndex) targetIndex - 1 else targetIndex
                                    )
                                }

                                1 -> {
                                    onSwap(selectedIndex, targetIndex)
                                }

                                2 -> {
                                    onMove(
                                        selectedIndex,
                                        if (selectedIndex < targetIndex) targetIndex else targetIndex + 1
                                    )
                                }
                            }
                            onDismiss()
                        }
                    ) {
                        Text(
                            text = "Confirm",
                            style = typography.bodySmall
                        )
                    }
                }


            }
        }
    )
}


