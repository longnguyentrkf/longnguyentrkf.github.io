package space.kingfu.sidePanel.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import space.kingfu.main.editor.state.Banner
import space.kingfu.main.ui.components.MyTextField
import space.kingfu.main.ui.theme.Typography
import space.kingfu.sidePanel.ui.components.menu.BannerMenu
import space.kingfu.sidePanel.ui.components.menu.TextMenu
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannerScreen(
    modifier: Modifier = Modifier,
    banner: Banner,
    goBack: () -> Boolean,
    bannerIndex: Int,
    setBannerIndex: (Int?) -> Unit,
    setBannerHeight: (Int, Dp) -> Unit,
    setBannerIsReverse: (Int, Boolean) -> Unit,
    setBannerImage: (Int, Int, String) -> Unit,
    addBannerText: (Int) -> Unit,
    setBannerText: (Int, Int, String) -> Unit,
    goToDialogConfirm: () -> Unit,
    goToDialogEditText: () -> Unit,
    goToDialogSelect: () -> Unit,
    addBannerImage: (Int) -> Unit
) {
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = banner.name,
                        style = Typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            setBannerIndex(null)
                            goBack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ChevronLeft,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    BannerMenu(
                        onDelete = goToDialogConfirm,
                        onEdit = goToDialogEditText,
                        onBanner = goToDialogSelect
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues = paddingValues)
                .verticalScroll(state = rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (banner.type == null) {
                Text(
                    modifier = Modifier
                        .clickable { goToDialogSelect() }
                        .padding(all = 16.dp)
                        .fillMaxWidth(),
                    text = "Select a banner type",
                    style = Typography.bodySmall
                )
            } else {
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
                        onValueChange = { setBannerHeight(bannerIndex, it.dp) },
                        valueRange = 100f..1100f,
                        steps = 9
                    )
                }

                if (banner is Banner.Banner1) {
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
                            onCheckedChange = { setBannerIsReverse(bannerIndex, it) }
                        )
                    }

                    Column {
                        val lazyRowState2 = rememberLazyListState()

                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                            items(count = banner.image.size) { index ->
                                MyTextField(
                                    modifier = Modifier
                                        .width(width = 236.dp)
                                        .height(height = 200.dp),
                                    value = banner.image[index].url,
                                    onValueChange = { setBannerImage(bannerIndex, index, it) },
                                    label = "image url"
                                )

                                Spacer(modifier = Modifier.width(width = 4.dp))
                            }

                            item {
                                Box(
                                    modifier = Modifier
                                        .clickable {
                                            scope.launch {
                                                addBannerImage(bannerIndex)
                                                lazyRowState2.animateScrollToItem(index = banner.image.size - 1)
                                            }
                                        }
                                        .fillMaxHeight()
                                        .background(color = colorScheme.surfaceContainer)
                                        .width(width = if (banner.image.isEmpty()) 300.dp else 60.dp)
                                        .height(200.dp)
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
                    }

                    Column {
                        val lazyRowState = rememberLazyListState()

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LazyRow(
                                modifier = Modifier
                                    .height(height = 300.dp)
                                    .fillMaxWidth(),
                                state = lazyRowState,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
                            ) {

                                item {
                                    Box(modifier = Modifier.width(width = 30.dp))
                                }


                                items(count = banner.texts.size) { index ->
                                    val text = banner.texts[index]

                                    MyTextField(
                                        modifier = Modifier
                                            .width(width = 232.dp)
                                            .fillMaxHeight(),
                                        value = text.text,
                                        onValueChange = { setBannerText(bannerIndex, index, it) },
                                        labelIconOnClick = {
                                            TextMenu(
                                                onDelete = { },
                                                onEdit = { },
                                                iconPadding = 0.dp
                                            )
                                        },
                                        label = text.name,
                                        labelMaxLines = 2,
                                    )
                                }


                                item {
                                    Box(
                                        modifier = Modifier
                                            .width(width = 30.dp)
                                            .clickable {
                                                scope.launch {
                                                    addBannerText(bannerIndex)
                                                    lazyRowState.animateScrollToItem(
                                                        index = banner.texts.size - 1,
                                                        scrollOffset = 500
                                                    )
                                                }
                                            }
                                            .fillMaxHeight()
                                            .background(color = colorScheme.surfaceContainer),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(size = 20.dp),
                                            imageVector = Icons.Rounded.Add,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


