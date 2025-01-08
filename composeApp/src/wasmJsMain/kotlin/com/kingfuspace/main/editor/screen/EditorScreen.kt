package com.kingfuspace.main.editor.screen

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.rememberScrollbarAdapter
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.ui.components.TwoColumnLayout
import com.kingfuspace.main.ui.theme.Typography
import kotlinx.browser.window
import kotlinx.coroutines.launch


@Composable
fun EditorScreen(
    modifier: Modifier = Modifier,
    banners: MutableList<Banner>,
    bannerIndex: Int?,
    setBannerIndex: (Int) -> Unit,
    goToBanner: () -> Unit,
    lazyListState: LazyListState,
    isSmallScreen: Boolean,
    screenWidth: Dp
) {
//    val screenWidth = LocalConfiguration.current.screenWidthDp // screen width in dp
    val screenWidth2 = window.innerWidth // Get the window's width in pixels
    val screenWidthTotal = window.screen.width.sp.value
    val scaleFactor = (screenWidth2 / screenWidthTotal).coerceIn(
        0.5f,
        1f
    ) // Assuming 1920px as your 100% scale width

    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 16.dp)
                .background(color = colorScheme.surfaceContainer),
            state = lazyListState
        ) {
            items(count = banners.size) { index ->
                val isSelected = bannerIndex == index
                val banner = banners[index]

                Column(
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
                        .aspectRatio(ratio = screenWidth / banner.height)
                        .height(height = banner.height)
                        .background(color = colorScheme.surface)

                ) {
                    Box {
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
                                    style = Typography.bodySmall,
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
                                    Box(
                                        contentAlignment = Alignment.BottomCenter
                                    ) {
                                        HorizontalPager(
                                            modifier = Modifier
                                                .height(height = banner.height)
                                                .fillMaxWidth(),
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
                                                style = typography.labelLarge,
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
                                        banner.texts.forEachIndexed { _, text ->
                                            Text(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clickable { },
                                                text = text.text,
                                                style = Typography.displayLarge.copy(
                                                    fontSize = Typography.displayLarge.fontSize * scaleFactor,
                                                    lineHeight = Typography.displayLarge.lineHeight * scaleFactor
                                                ),
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                },
                                isSmallScreen = screenWidth < 900.dp
                            )
                        }

                    }
                }
            }
        }

        VerticalScrollbar(
            modifier = Modifier
                .align(alignment = Alignment.CenterEnd)
                .fillMaxHeight()
                .padding(end = 2.dp),
            adapter = rememberScrollbarAdapter(scrollState = lazyListState),
            style = defaultScrollbarStyle().copy(
                thickness = 12.dp,
//                unhoverColor = colorScheme.outlineVariant,
//                hoverColor = colorScheme.outlineVariant,
                unhoverColor = colorScheme.surfaceContainer,
                hoverColor = colorScheme.surfaceContainer,
                minimalHeight = 24.dp,
                shape = CircleShape
            )
        )

    }
}
