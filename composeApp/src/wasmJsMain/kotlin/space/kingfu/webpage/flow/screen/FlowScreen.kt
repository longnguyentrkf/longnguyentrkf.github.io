package space.kingfu.webpage.flow.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.core.Variables.maxWidth
import space.kingfu.webpage.core.Variables.theme
import space.kingfu.webpage.core.setTheme
import space.kingfu.webpage.flow.screen.components.FlowHeader
import space.kingfu.webpage.flow.ui.FlowButton
import space.kingfu.webpage.flow.ui.FlowImage
import space.kingfu.webpage.flow.ui.FlowText
import space.kingfu.webpage.flow.viewModel.Banner
import space.kingfu.webpage.flow.viewModel.ButtonData
import space.kingfu.webpage.flow.viewModel.Header
import space.kingfu.webpage.flow.viewModel.ImageData
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.topBar.BackTopBar
import space.kingfu.webpage.topBar.FlowTopBar
import space.kingfu.webpage.ui.components.TwoColumnLayout
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.ThemeType
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowScreen(
    banners: List<Banner>,
    addBanner: () -> Unit,
    goToTemplate: () -> Unit,
    removeButton: (index: Int, buttonIndex: Int) -> Unit,
    addButton: (index: Int) -> Unit,
    setTitle: (index: Int, textData: TextData) -> Unit,
    setSubtitle: (index: Int, textData: TextData) -> Unit,
    setBody: (index: Int, textData: TextData) -> Unit,
    setFooter: (index: Int, textData: TextData) -> Unit,
    setButtons: (index: Int, buttonIndex: Int, buttonData: ButtonData) -> Unit,
    setImage: (index: Int, image: ImageData) -> Unit,
    setImageHeader: (ImageData) -> Unit,
    header: Header,
    setHeaderTitle2: (TextData) -> Unit,
    setHeadertitle1: (TextData) -> Unit,
    setButtonsHeader: (Int, ButtonData) -> Unit,
    addButtonHeader: () -> Unit,
    removeButtonHeader: (index: Int) -> Unit,
    setTopBarTitle: (TextData) -> Unit,
    topBarTitle: TextData,
    setBannerTitle: (Int, TextData) -> Unit,
    deleteBanner: (Int) -> Unit
) {


    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()



    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            BackTopBar(
                navigationIconOnClick = goToTemplate,
                name = Screen.Flow.name,
                scrollBehavior = scrollBehavior,
                actions = {
                    IconButton(
                        colors = IconButtonDefaults.iconButtonColors(),
                        onClick = { setTheme(theme) }) {
                        Icon(
                            imageVector = if (theme == ThemeType.LIGHT) Icons.Rounded.Bedtime else Icons.Rounded.LightMode,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues1 ->
        Scaffold(
            modifier = Modifier.padding(paddingValues = paddingValues1),
            topBar = {
                FlowTopBar(
                    title = topBarTitle,
                    setTopBarTitle = setTopBarTitle,
                    topBarTitle = topBarTitle
                )
            }
        ) { paddingValues2 ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues = paddingValues2)
                    .verticalScroll(state = scrollState),
                verticalArrangement = Arrangement.spacedBy(space = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FlowHeader(
                    header = header,
                    setImageHeader = setImageHeader,
                    setHeaderTitle1 = setHeadertitle1,
                    setHeaderTitle2 = setHeaderTitle2,
                    setButtonsHeader = setButtonsHeader,
                    removeButtonHeader = removeButtonHeader,
                    addButtonHeader = addButtonHeader
                )

                banners.forEachIndexed { index, banner ->
                    Column(
                        modifier = Modifier.padding(horizontal = 24.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = { deleteBanner(index) }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Close,
                                    contentDescription = null,
                                    tint = colorScheme.error
                                )
                            }

                            Text(
                                text = "banner ${index + 1}",
                                style = Typography.bodySmall
                            )
                        }

                        Spacer(modifier = Modifier.height(height = 24.dp))

                        FlowText(
                            modifier = Modifier
                                .widthIn(max = 1200.dp)
                                .padding(horizontal = 24.dp),
                            isEdit = banner.bannerTitle.isEdit,
                            onValueChange = {
                                setBannerTitle(
                                    index,
                                    TextData(isEdit = true, text = it)
                                )
                            },
                            placeholder = "banner title",
                            text = banner.bannerTitle.text,
                            done = {
                                setBannerTitle(
                                    index,
                                    TextData(isEdit = false, text = banner.bannerTitle.text)
                                )
                            },
                            clickable = {
                                setBannerTitle(
                                    index,
                                    TextData(isEdit = true, text = banner.bannerTitle.text)
                                )
                            },
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            contentAlignment = Alignment.Center,
                            isSingleLine = true
                        )
                    }

                    TwoColumnLayout(
                        modifier = Modifier.widthIn(max = 1200.dp),
                        isReverseLayout = index % 2 != 0,
                        width = maxWidth,
                        left = {
                            FlowImage(
                                image = banner.image,
                                onClick = {
                                    setImage(
                                        index,
                                        ImageData(
                                            isEdit = !banner.image.isEdit,
                                            url = banner.image.url
                                        )
                                    )
                                },
                                onValueChange = {
                                    setImage(index, ImageData(isEdit = true, url = it))
                                }
                            )
                        },
                        right = {
                            FlowText(
                                placeholder = "title",
                                isEdit = banner.title.isEdit,
                                onValueChange = {
                                    setTitle(index, TextData(isEdit = true, text = it))
                                },
                                text = banner.title.text,
                                done = {
                                    setTitle(
                                        index,
                                        TextData(isEdit = false, text = banner.title.text)
                                    )
                                },
                                clickable = {
                                    setTitle(
                                        index,
                                        TextData(isEdit = true, text = banner.title.text)
                                    )
                                },
                                style = Typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                contentAlignment = Alignment.Center
                            )

                            FlowText(
                                placeholder = "subtitle",
                                text = banner.subtitle.text,
                                isEdit = banner.subtitle.isEdit,
                                onValueChange = {
                                    setSubtitle(index, TextData(isEdit = true, text = it))
                                },
                                done = {
                                    setSubtitle(
                                        index,
                                        TextData(isEdit = false, text = banner.subtitle.text)
                                    )
                                },
                                clickable = {
                                    setSubtitle(
                                        index,
                                        TextData(isEdit = true, text = banner.subtitle.text)
                                    )
                                },
                                fontStyle = FontStyle.Italic,
                                contentAlignment = Alignment.Center,
                                textAlign = TextAlign.Center
                            )


                            FlowText(
                                placeholder = "body",
                                text = banner.body.text,
                                isEdit = banner.body.isEdit,
                                onValueChange = {
                                    setBody(index, TextData(isEdit = true, text = it))
                                },
                                done = {
                                    setBody(
                                        index,
                                        TextData(isEdit = false, text = banner.body.text)
                                    )
                                },
                                clickable = {
                                    setBody(
                                        index,
                                        TextData(isEdit = true, text = banner.body.text)
                                    )
                                },
                                maxChar = 500,
                                textAlign = TextAlign.Justify
                            )


                            FlowText(
                                placeholder = "footer",
                                text = banner.footer.text,
                                isEdit = banner.footer.isEdit,
                                onValueChange = {
                                    setFooter(index, TextData(isEdit = true, text = it))
                                },
                                done = {
                                    setFooter(
                                        index,
                                        TextData(isEdit = false, text = banner.footer.text)
                                    )
                                },
                                clickable = {
                                    setFooter(
                                        index,
                                        TextData(isEdit = true, text = banner.footer.text)
                                    )
                                },
                                textAlign = TextAlign.Justify,
                                textColor = colorScheme.outline
                            )

                            Row(
                                modifier = Modifier.horizontalScroll(state = rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
                            ) {
                                banner.buttons.forEachIndexed { buttonIndex, buttonData ->
                                    FlowButton(
                                        buttonData = buttonData,
                                        done = {
                                            setButtons(
                                                index,
                                                buttonIndex,
                                                ButtonData(
                                                    text = buttonData.text,
                                                    isEdit = false,
                                                    url = buttonData.url
                                                )
                                            )
                                        },
                                        onValueChangeButton = {
                                            setButtons(
                                                index,
                                                buttonIndex,
                                                ButtonData(
                                                    text = it,
                                                    isEdit = true,
                                                    url = buttonData.url
                                                )
                                            )
                                        },
                                        onValueChangeUrl = {
                                            setButtons(
                                                index,
                                                buttonIndex,
                                                ButtonData(
                                                    url = it,
                                                    isEdit = true,
                                                    text = buttonData.text
                                                )
                                            )
                                        },
                                        remove = { removeButton(index, buttonIndex) },
//                                        add = { addButton(index) },
                                        onClick = {
                                            setButtons(
                                                index,
                                                buttonIndex,
                                                ButtonData(
                                                    text = buttonData.text,
                                                    isEdit = true,
                                                    url = buttonData.url
                                                )
                                            )
                                        }
                                    )
                                }

                                if (banner.buttons.size < 2) {
                                    IconButton(onClick = { addButton(index) }) {
                                        Icon(
                                            imageVector = Icons.Rounded.Add,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .widthIn(max = 1200.dp)
                        .fillMaxWidth()
                        .height(height = 240.dp)
                        .horizontalScroll(state = rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(space = 24.dp)
                ) {
                    if (banners.size < 5) {
                        Row(
                            modifier = Modifier
//                                .padding(vertical = 24.dp)
                                .fillMaxHeight()
                                .weight(1f)
//                                .width(width = 200.dp)
//                                .widthIn(max = 1200.dp)
//                                .fillMaxWidth()
//                                .height(height = 240.dp)
//                                .padding(horizontal = 24.dp)
                                .clip(shape = Shape.small)
                                .background(color = colorScheme.surfaceContainer)
                                .clickable { addBanner() },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Add Banner",
                                style = Typography.bodySmall
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
//                            .width(width = 200.dp)
//                        .widthIn(max = 1200.dp)
//                        .fillMaxWidth()
//                        .height(height = 240.dp)
//                            .padding(horizontal = 24.dp)
                            .clip(shape = Shape.small)
                            .background(color = colorScheme.surfaceContainer)
                            .clickable { },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "Add Footer",
                            style = Typography.bodySmall
                        )
                    }
                }



                Spacer(modifier = Modifier.height(height = 180.dp))

            }
        }
    }
}

