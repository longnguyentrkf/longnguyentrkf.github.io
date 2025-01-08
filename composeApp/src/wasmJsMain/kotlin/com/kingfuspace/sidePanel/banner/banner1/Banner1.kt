package com.kingfuspace.sidePanel.banner.banner1

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.ui.components.MyTextField
import com.kingfuspace.main.ui.theme.Typography
import com.kingfuspace.sidePanel.ui.components.menu.BannerMenu
import kotlinx.coroutines.launch

@Composable
fun Banner1(
    modifier: Modifier = Modifier,
    banner: Banner.Banner1,
    bannerIndex: Int,
    setIsReverse: (Int, Boolean) -> Unit,
    setImage: (Int, Int, String) -> Unit,
    setText: (Int, Int, String) -> Unit,
    addText: (Int) -> Unit,
    addImage: (Int) -> Unit,
    deleteText: (Int, Int) -> Unit,
    deleteImage: (Int, Int) -> Unit,
    goToDialogMoveImages: (Int) -> Unit,
    goToSetTextName: (String, Int) -> Unit,
    goToSetImageName: (String, Int) -> Unit,
    goToDialogMoveTexts: (Int) -> Unit,
    goToComponentImage: (Int) -> Unit,
    goToComponentText: (Int) -> Unit
) {

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        Row(
            modifier = modifier
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

        Box {
            val lazyRowState = rememberLazyListState()

            LazyRow(
                modifier = Modifier.padding(bottom = 16.dp),
                state = lazyRowState,
                horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
            ) {
                items(count = banner.images.size) { index ->
                    Column(modifier = Modifier.width(width = 300.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = colorScheme.surfaceContainer)
                                .padding(start = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(weight = 1f),
                                text = banner.images[index].name,
                                style = typography.labelLarge,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis

                            )

                            BannerMenu(
                                modifier = Modifier.weight(weight = 0.2f),
                                onDelete = if (banner.images.size == 1) null else {
                                    { deleteImage(bannerIndex, index) }
                                },
                                onEditName = {
                                    goToSetImageName(
                                        banner.images[index].name,
                                        index
                                    )
                                },
                                onMove = if (banner.images.size > 1) {
                                    { goToDialogMoveImages(index) }
                                } else null,
                                onModify = { goToComponentImage(index) },
                                onAdd = {
                                    scope.launch {
                                        addImage(bannerIndex)
                                        lazyRowState.animateScrollToItem(index = banner.images.size - 1)
                                    }
                                }
                            )
                        }

                        AsyncImage(
                            modifier = Modifier
                                .height(height = 150.dp)
                                .fillMaxWidth()
                                .background(color = colorScheme.surfaceContainerLow),
                            model = banner.images[index].url,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
//                                            contentScale = ContentScale.Fit,
                        )

                        MyTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = colorScheme.surfaceContainer),
                            value = banner.images[index].url,
                            onValueChange = { setImage(bannerIndex, index, it) },
                            label = "image url",
                            isSingleLine = true
                        )

                    }
                }
            }

            HorizontalScrollbar(
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .fillMaxWidth(),
                adapter = rememberScrollbarAdapter(scrollState = lazyRowState),
                style = defaultScrollbarStyle().copy(
                    thickness = 12.dp,
//                    unhoverColor = colorScheme.outlineVariant,
//                    hoverColor = colorScheme.outlineVariant,
                    unhoverColor = colorScheme.surfaceContainer,
                    hoverColor = colorScheme.surfaceContainer,
                    minimalHeight = 24.dp,
                    shape = CircleShape
                )
            )
        }


        Box {
            val lazyRowState = rememberLazyListState()

            LazyRow(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                state = lazyRowState,
                horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
            ) {
                items(count = banner.texts.size) { index ->
                    val text = banner.texts[index]

                    Column(modifier = Modifier.width(width = 300.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = colorScheme.surfaceContainer)
                                .padding(start = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(weight = 1f),
                                text = banner.texts[index].name,
                                style = typography.labelLarge,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            BannerMenu(
                                modifier = Modifier.weight(weight = 0.2f),
                                onDelete = if (banner.texts.size == 1) null else {
                                    { deleteText(bannerIndex, index) }
                                },
                                onEditName = { goToSetTextName(text.name, index) },
                                onMove = if (banner.texts.size == 1) null else {
                                    { goToDialogMoveTexts(index) }
                                },
                                onModify = { goToComponentText(index) },
                                onAdd = {
                                    scope.launch {
                                        addText(bannerIndex)
                                        lazyRowState.animateScrollToItem(index = banner.texts.size - 1)
                                    }
                                }
                            )
                        }

                        MyTextField(
                            modifier = Modifier
                                .background(color = colorScheme.surfaceContainerLow)
                                .fillMaxWidth()
                                .height(height = 200.dp),
                            value = text.text,
                            onValueChange = {
                                setText(
                                    bannerIndex,
                                    index,
                                    it
                                )
                            }
                        )
                    }
                }
            }

            HorizontalScrollbar(
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .fillMaxWidth(),
                adapter = rememberScrollbarAdapter(scrollState = lazyRowState),
                style = defaultScrollbarStyle().copy(
                    thickness = 12.dp,
//                    unhoverColor = colorScheme.outlineVariant,
//                    hoverColor = colorScheme.outlineVariant,
                    unhoverColor = colorScheme.surfaceContainer,
                    hoverColor = colorScheme.surfaceContainer,
                    minimalHeight = 24.dp,
                    shape = CircleShape
                )
            )
        }
    }
}