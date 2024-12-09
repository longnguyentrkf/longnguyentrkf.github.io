package space.kingfu.sidePanel.banner.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Title
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import space.kingfu.main.editor.state.Banner
import space.kingfu.main.ui.components.MyTextField
import space.kingfu.main.ui.theme.Typography
import space.kingfu.sidePanel.ui.components.menu.TextMenu
import kotlin.math.roundToInt

@Composable
fun Banner1(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    banner: Banner.Banner1,
    setHeight: (Int, Dp) -> Unit,
    bannerIndex: Int,
    setIsReverse: (Int, Boolean) -> Unit,
    setImage: (Int, String) -> Unit,
    setText: (Int, Int, String) -> Unit,
    addText: (Int) -> Unit
) {

    val scope = rememberCoroutineScope()
    val lazyRowState = rememberLazyListState()


    Column(
        modifier = modifier
            .padding(paddingValues = paddingValues)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (banner.type != null) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(weight = 1f),
                    text = "Height: ${(banner.height.value / 10).roundToInt()}%",
                    style = Typography.bodySmall,
                    textAlign = TextAlign.Start
                )

                Slider(
                    modifier = Modifier
                        .weight(weight = 1f)
                        .height(height = 8.dp),
                    value = banner.height.value,
                    onValueChange = { setHeight(bannerIndex, it.dp) },
                    valueRange = 400f..1000f,
                    steps = 2
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Reverse Layout:",
                    style = Typography.bodySmall
                )

                Switch(
                    modifier = Modifier.scale(scale = 0.75f),
                    checked = banner.isReverse,
                    onCheckedChange = { setIsReverse(bannerIndex, it) }
                )
            }

//            MyTextField(
//                modifier = Modifier.padding(horizontal = 16.dp),
//                value = banner.image.url,
//                onValueChange = { setImage(bannerIndex, it) },
//                isSingleLine = true,
//                maxLines = 1,
//                label = "image url"
//            )

            Column {
                LazyRow(
                    modifier = Modifier
                        .height(height = 300.dp)
                        .fillMaxWidth(),
                    state = lazyRowState,
                    userScrollEnabled = false,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(count = banner.texts.size) { index ->
                        val isEnabled = index == lazyRowState.firstVisibleItemIndex
                        val text = banner.texts[index]

                        MyTextField(
                            modifier = Modifier
                                .width(width = 236.dp)
                                .fillMaxHeight(),
                            value = text.text,
                            onValueChange = { setText(bannerIndex, index, it) },
                            isEnabled = isEnabled,
                        )

                        Spacer(modifier = Modifier.width(width = 4.dp))
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .clickable { addText(bannerIndex) }
                                .fillMaxHeight()
                                .background(color = colorScheme.surfaceContainer)
                                .width(width = if (banner.texts.isEmpty()) 300.dp else 60.dp)
                                .padding(all = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Add,
                                contentDescription = null
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .weight(weight = if (banner.texts.size == 1) 1f else 0.67f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        TextMenu(
                            onDelete = if (banner.texts.size > 1) {
                                { }
                            } else null,
                            onEdit = { }
                        )
                        Text(
                            text = banner.texts[lazyRowState.firstVisibleItemIndex].name,
                            style = Typography.labelLarge,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    if (banner.texts.size > 1) {
                        Row(
                            modifier = Modifier.weight(weight = 0.33f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            val index = lazyRowState.firstVisibleItemIndex

                            IconButton(
                                modifier = Modifier.alpha(alpha = if (index > 0) 1f else 0f),
                                enabled = index > 0,
                                onClick = {
                                    scope.launch {
                                        lazyRowState.animateScrollToItem(
                                            index = index.dec()
                                        )
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.ChevronLeft,
                                    contentDescription = null
                                )
                            }


                            Text(
                                text = "${lazyRowState.firstVisibleItemIndex + 1}",
                                style = Typography.bodySmall
                            )

                            IconButton(
                                modifier = Modifier.alpha(alpha = if (index < banner.texts.size - 1) 1f else 0f),
                                enabled = index < banner.texts.size - 1,
                                onClick = {
                                    scope.launch {
                                        lazyRowState.animateScrollToItem(
                                            index = index.inc()
                                        )
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.ChevronRight,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.horizontalScroll(state = rememberScrollState())
                ) {
                    for (i in 0 until 10) {
                        IconButton(
                            modifier = Modifier.clip(shape = RectangleShape),
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Title,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}