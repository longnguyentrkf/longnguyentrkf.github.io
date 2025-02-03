package com.kingfuspace.sidePanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kingfuspace.main.editor.state.ImageData
import com.kingfuspace.main.ui.components.MyTextField
import com.kingfuspace.sidePanel.ui.components.menu.BannerMenu
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentImage(
    modifier: Modifier = Modifier,
    goBack: () -> Boolean,
    image: ImageData,
    goToSetTextName: () -> Unit,
    index: Int,
    bannerIndex: Int,
    setImage: (Int, Int, String) -> Unit
) {

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(weight = 1f),
                            text = image.name,
                            style = typography.labelMedium,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        BannerMenu(
                            modifier = Modifier.weight(weight = 0.2f),
                            onDelete = { },
                            onEditName = { goToSetTextName() },
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { goBack() }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ChevronLeft,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues = paddingValues),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {
            Column {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 200.dp)
                        .background(color = colorScheme.surfaceContainerHigh),
                    model = image.url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
//                                            contentScale = ContentScale.Fit,
                )

                MyTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorScheme.surfaceContainer),
                    value = image.url,
                    onValueChange = { setImage(bannerIndex, index, it) },
                    label = "image url",
                    isSingleLine = true
                )
            }

            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(weight = 1f),
                    text = "Scale: ${(600f / 10).roundToInt()}%",
                    style = Typography().labelMedium,
                    textAlign = TextAlign.Start
                )

                Slider(
                    modifier = Modifier
                        .weight(weight = 1f)
                        .height(height = 8.dp),
                    value = 600f,
                    onValueChange = { },
                    valueRange = 100f..1100f,
                    steps = 9
                )
            }
        }
    }
}