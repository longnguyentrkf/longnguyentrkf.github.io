package com.kingfuspace.sidePanel.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kingfuspace.main.editor.state.TextData
import com.kingfuspace.main.ui.components.MyHorizontalScrollBar

@Composable
fun DialogMoveTexts(
    modifier: Modifier = Modifier,
    texts: List<TextData>,
    onDismiss: () -> Unit,
    onSwap: (Int, Int, Int) -> Unit,
    selectedIndex: Int,
    onMove: (Int, Int, Int) -> Unit,
    bannerIndex: Int
) {

    var optionsIndex by remember { mutableStateOf(value = 1) }
    val options = listOf("Left", "Swap", "Right")

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
                            label = { Text(text = label, style = typography.labelSmall) },
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
                                    .background(color = if (targetIndex == index || selectedIndex == index) colorScheme.inverseSurface else colorScheme.surfaceContainer)
                                    .clickable(enabled = index != selectedIndex) {
                                        targetIndex = index
                                    }
                                    .alpha(alpha = if (index == targetIndex || index == selectedIndex) 1f else 0.5f)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(height = 40.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(all = 8.dp),
                                        text = texts[index].name,
//                                        style = typography.labelLarge,
                                        style = typography.labelSmall,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        color = if (targetIndex == index || selectedIndex == index) colorScheme.surface else colorScheme.inverseSurface
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .size(size = 150.dp)
                                        .background(color = if (targetIndex == index || selectedIndex == index) colorScheme.surfaceContainerHigh else colorScheme.surfaceContainerLow)
                                        .padding(all = 4.dp)
                                        .verticalScroll(state = rememberScrollState())
                                ) {
                                    Text(
                                        text = texts[index].text,
//                                        style = typography.bodySmall
                                        style = typography.labelMedium
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(height = 40.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(all = 8.dp),
                                        text = when (index) {
                                            targetIndex -> "target"
                                            selectedIndex -> "selected"
                                            else -> ""
                                        },
//                                        style = typography.labelLarge,
                                        style = typography.labelSmall,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        color = if (targetIndex == index || selectedIndex == index) colorScheme.surface else colorScheme.inverseSurface
                                    )
                                }
                            }
                        }
                    }

                    MyHorizontalScrollBar(lazyListState = lazyRowState)
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
                                        bannerIndex,
                                        selectedIndex,
                                        if (selectedIndex < targetIndex) targetIndex - 1 else targetIndex
                                    )
                                }

                                1 -> {
                                    onSwap(bannerIndex, selectedIndex, targetIndex)
                                }

                                2 -> {
                                    onMove(
                                        bannerIndex,
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
//                            style = typography.bodySmall
                            style = typography.labelMedium
                        )
                    }
                }


            }
        }
    )
}


