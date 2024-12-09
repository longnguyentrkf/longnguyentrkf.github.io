package space.kingfu.main.editor.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import space.kingfu.main.editor.state.Banner
import space.kingfu.main.editor.state.BannerType
import space.kingfu.main.ui.components.TwoColumnLayout
import space.kingfu.main.ui.theme.Typography


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
    val focusManager = LocalFocusManager.current


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
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

                    if (banner.type == BannerType.TYPE_1 && banner is Banner.Banner1) {
                        TwoColumnLayout(
                            isReverseLayout = banner.isReverse,
                            left = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(height = banner.height)
                                        .horizontalScroll(
                                            state = rememberScrollState(),
                                        )
                                ) {
                                    banner.image.forEachIndexed { index, imageData ->
//                                        Box(
//                                            modifier = Modifier
//                                                .height(height = banner.height)
////                                                .fillParentMaxWidth(0.5f),
//                                                .fillParentMaxWidth(1f/(banner.image.size+1)),
//                                            contentAlignment = Alignment.Center
//                                        ) {
                                            AsyncImage(
                                                modifier = Modifier
                                                    .height(height = banner.height)
//                                                    .fillMaxSize()
//                                                    .fillParentMaxWidth(1f/banner.image.size),
                                                    .fillParentMaxWidth(0.5f),
//                                                    .fillParentMaxSize(),
                                                model = imageData.url,
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
//                                            contentScale = ContentScale.Fit,
                                            )
//                                        }
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
                                            style = Typography.displayLarge,
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
}
