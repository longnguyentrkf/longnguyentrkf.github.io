package com.kingfuspace.main.editor.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.kingfuspace.main.core.Variables.windowWidth
import com.kingfuspace.main.core.isSmallScreen
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.ui.components.MyVerticalScrollBar
import com.kingfuspace.main.editor.screen.components.layouts.TwoColumnLayout
import kotlinx.coroutines.launch


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditorScreen(
    modifier: Modifier = Modifier,
    banners: MutableList<Banner>,
    bannerIndex: Int?,
    setBannerIndex: (Int) -> Unit,
    goToBanner: () -> Unit,
    lazyListState: LazyListState,
    sidePanelWidth: Dp
) {
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 16.dp)
                .background(color = colorScheme.surfaceContainer),
            state = lazyListState
        ) {
            items(count = banners.size, key = { banners[it].id }) { index ->
                val isSelected = bannerIndex == index
                val banner = banners[index]
                val bannerHeight =
                    if (isSmallScreen(addedWidth = sidePanelWidth.value.toInt())) banner.height * 3 else banner.height

                Box(
                    modifier = Modifier
                        .clickable {
                            goToBanner()
                            setBannerIndex(index)
                        }
                        .border(
                            width = if (isSelected) 1.dp else 0.dp,
                            shape = RectangleShape,
                            color = if (isSelected) colorScheme.inverseSurface else Transparent
                        )
                        .fillMaxWidth()
                        .aspectRatio(ratio = windowWidth.dp / bannerHeight)
                        .height(height = bannerHeight)
                        .background(color = colorScheme.surface)
                ) {
                    if (bannerIndex == index) {
                        Box(
                            modifier = Modifier
                                .zIndex(zIndex = 1f)
                                .background(color = colorScheme.inverseSurface)
                                .padding(all = 2.dp)
                        ) {
                            Text(
                                modifier = Modifier.widthIn(max = 200.dp),
                                text = banner.name,
                                style = typography.labelMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = colorScheme.surface
                            )
                        }
                    }

                    if (banner is Banner.Banner1) {

                        val pagerState = rememberPagerState(pageCount = { banner.images.size })
                        val currentPage = pagerState.currentPage

                        TwoColumnLayout(
                            isReverseLayout = banner.isReverse,
                            left = {
                                Box(contentAlignment = Alignment.BottomCenter) {
                                    HorizontalPager(
                                        modifier = Modifier.height(height = bannerHeight),
                                        state = pagerState
                                    ) { index ->
                                        AsyncImage(
                                            modifier = Modifier.fillMaxSize(),
                                            model = banner.images[index].url,
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
//                                            contentScale = ContentScale.Fit,
                                        )
                                    }

                                    Row(
                                        modifier = Modifier
                                            .alpha(alpha = if (banner.images.size > 1) 1f else 0f)
                                            .padding(bottom = 4.dp)
                                            .background(
                                                color = colorScheme.surface.copy(alpha = 0.75f),
                                                shape = CircleShape
                                            )
                                            .padding(all = 4.dp),

                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .clickable(
                                                    enabled = currentPage != 0
                                                ) {
                                                    scope.launch {
                                                        pagerState.animateScrollToPage(
                                                            page = currentPage.dec()
                                                        )
                                                    }
                                                }
                                                .size(size = 24.dp)
                                                .alpha(alpha = if (currentPage != 0) 0.75f else 0.25f),
                                            imageVector = Icons.Rounded.ChevronLeft,
                                            contentDescription = null
                                        )

                                        Text(
                                            text = "${currentPage + 1}/${banner.images.size}",
                                            style = typography.labelMedium,
                                        )

                                        Icon(
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .clickable(
                                                    enabled = currentPage != banner.images.size - 1
                                                ) {
                                                    scope.launch {
                                                        pagerState.animateScrollToPage(
                                                            page = currentPage.inc()
                                                        )
                                                    }
                                                }
                                                .size(size = 24.dp)
                                                .alpha(alpha = if (currentPage != banner.images.size - 1) 0.75f else 0.25f),
                                            imageVector = Icons.Rounded.ChevronRight,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            right = {
                                Column(
                                    modifier = Modifier.verticalScroll(state = rememberScrollState())
                                ) {
//
                                    banner.texts.forEachIndexed { index, text ->
                                        Text(
                                            modifier = Modifier
                                                .clickable(enabled = text.isClickable) { }
                                                .padding(all = 24.dp),
                                            text = text.text,
                                            style = banner.texts[index].style.copy(
                                                fontSize = banner.texts[index].style.fontSize,
                                                lineHeight = banner.texts[index].style.lineHeight
                                            )
                                        )
                                    }
                                }
                            },
                            isSmallScreen = isSmallScreen(addedWidth = sidePanelWidth.value.toInt())
                        )
                    }
                }
            }
        }

        MyVerticalScrollBar(scrollState = lazyListState)

    }
}
