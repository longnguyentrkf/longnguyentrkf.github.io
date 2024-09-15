package space.kingfu.webpage.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.core.variables.maxWidth
import space.kingfu.webpage.flow.components.FlowBody
import space.kingfu.webpage.flow.components.FlowButton
import space.kingfu.webpage.flow.components.FlowButtonHeader
import space.kingfu.webpage.flow.components.FlowFooter
import space.kingfu.webpage.flow.components.FlowImage
import space.kingfu.webpage.flow.components.FlowImageHeader
import space.kingfu.webpage.flow.components.FlowSubtitle
import space.kingfu.webpage.flow.components.FlowSubtitleHeader
import space.kingfu.webpage.flow.components.FlowTitle
import space.kingfu.webpage.flow.components.FlowTitleHeader
import space.kingfu.webpage.flow.viewModel.Banner
import space.kingfu.webpage.flow.viewModel.ButtonData
import space.kingfu.webpage.flow.viewModel.Header
import space.kingfu.webpage.flow.viewModel.ImageData
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.topBar.BackTopBar
import space.kingfu.webpage.ui.components.TwoColumnLayout
import space.kingfu.webpage.ui.theme.Shape
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowScreen(
    banners: List<Banner>,
    addDetails: () -> Unit,
    goToTemplate: () -> Unit,
    removeButton: (index: Int, buttonIndex: Int) -> Unit,
    addButton: (indexSection: Int) -> Unit,
    setTitle: (index: Int, textData: TextData) -> Unit,
    setSubtitle: (index: Int, textData: TextData) -> Unit,
    setBody: (index: Int, textData: TextData) -> Unit,
    setFooter: (index: Int, textData: TextData) -> Unit,
    setButtons: (index: Int, buttonIndex: Int, buttonData: ButtonData) -> Unit,
    setImage: (index: Int, image: ImageData) -> Unit,
    setImageHeader: (ImageData) -> Unit,
    header: Header,
    setTitleHeader: (TextData) -> Unit,
    setSubtitleHeader: (TextData) -> Unit,
    setButtonsHeader: (Int, ButtonData) -> Unit,
    addButtonHeader: () -> Unit,
    removeButtonHeader: (index: Int) -> Unit
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues)
                .verticalScroll(state = scrollState),
            verticalArrangement = Arrangement.spacedBy(space = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TwoColumnLayout(
                width = maxWidth,
                left = {
                    FlowImageHeader(
                        image = header.image,
                        setImage = setImageHeader
                    )
                },
                right = {

                    FlowSubtitleHeader(
                        title = header.subtitle,
                        setTitle = setSubtitleHeader,
                        placeholder = "title 1"
                    )

                    Spacer(modifier = Modifier.height(height = 12.dp))

                    FlowTitleHeader(
                        title = header.title,
                        setTitle = setTitleHeader,
                        placeholder = "title 2"
                    )

                    Spacer(modifier = Modifier.height(height = 12.dp))


                    FlowButtonHeader(
                        setButtons = setButtonsHeader,
                        buttons = header.buttons,
                        removeButton = removeButtonHeader,
                        addButton = addButtonHeader
                    )


                }
            )
            banners.forEachIndexed { index, banner ->
                TwoColumnLayout(
                    modifier = Modifier.widthIn(max = 1200.dp),
                    isReverseLayout = index % 2 != 0,
                    width = maxWidth,
                    left = {
                        FlowImage(
                            index = index,
                            image = banner.image,
                            setImage = setImage
                        )
                    },
                    right = {
                        FlowTitle(
                            index = index,
                            title = banner.title,
                            setTitle = setTitle
                        )

                        FlowSubtitle(
                            index = index,
                            setSubtitle = setSubtitle,
                            subtitle = banner.subtitle
                        )

                        FlowBody(
                            index = index,
                            setBody = setBody,
                            body = banner.body
                        )

                        FlowFooter(
                            index = index,
                            setFooter = setFooter,
                            footer = banner.footer
                        )

                        FlowButton(
                            index = index,
                            setButtons = setButtons,
                            buttons = banner.buttons,
                            addButton = addButton,
                            removeButton = removeButton
                        )
                    }
                )
            }

            if (banners.size < 5) {
                Box(
                    modifier = Modifier
                        .widthIn(max = 1200.dp)
                        .fillMaxWidth()
                        .height(height = 240.dp)
                        .padding(horizontal = 24.dp)
                        .clip(shape = Shape.medium)
                        .background(color = colorScheme.surfaceContainer)
                        .clickable { addDetails() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(height = 180.dp))

        }
    }
}

