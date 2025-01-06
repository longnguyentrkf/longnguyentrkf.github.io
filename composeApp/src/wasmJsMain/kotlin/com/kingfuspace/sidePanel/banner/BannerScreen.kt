package com.kingfuspace.sidePanel.banner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.ui.theme.Typography
import com.kingfuspace.sidePanel.banner.banner1.Banner1
import com.kingfuspace.sidePanel.ui.components.menu.BannerMenu
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannerScreen(
    modifier: Modifier = Modifier,
    banner: Banner,
    goBack: () -> Boolean,
    bannerIndex: Int,
    setIndex: (Int?) -> Unit,
    setHeight: (Int, Dp) -> Unit,
    setIsReverse: (Int, Boolean) -> Unit,
    setImage: (Int, Int, String) -> Unit,
    addText: (Int) -> Unit,
    setTextValue: (Int, Int, String) -> Unit,
    goToDialogConfirm: () -> Unit,
    goToSetBannerName: () -> Unit,
    goToDialogSelect: () -> Unit,
    addImage: (Int) -> Unit,
    deleteText: (Int, Int) -> Unit,
    deleteImage: (Int, Int) -> Unit,
    goToDialogMoveImages: (Int) -> Unit,
    goToSetTextName: (String, Int) -> Unit,
    goToSetImageName: (String, Int) -> Unit,
    goToDialogMoveTexts: (Int) -> Unit,
    goToComponentImage: (Int) -> Unit,
) {

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
                            setIndex(null)
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
                        onEditName = goToSetBannerName,
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
            if (banner.bannerType == null) {
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
                        onValueChange = { setHeight(bannerIndex, it.dp) },
                        valueRange = 100f..1100f,
                        steps = 9
                    )
                }


                if (banner is Banner.Banner1) {
                    Banner1(
                        banner = banner,
                        bannerIndex = bannerIndex,
                        setIsReverse = setIsReverse,
                        setImage = setImage,
                        setText = setTextValue,
                        addText = addText,
                        addImage = addImage,
                        deleteText = deleteText,
                        deleteImage = deleteImage,
                        goToDialogMoveImages = goToDialogMoveImages,
                        goToSetTextName = goToSetTextName,
                        goToSetImageName = goToSetImageName,
                        goToDialogMoveTexts = goToDialogMoveTexts,
                        goToComponentImage = goToComponentImage
                    )
                }
            }
        }
    }
}


