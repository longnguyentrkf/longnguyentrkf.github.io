package com.kingfuspace.sidePanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kingfuspace.main.editor.state.ImageData
import com.kingfuspace.main.ui.theme.Typography
import com.kingfuspace.sidePanel.navigation.SidePanelDestination


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentImage(
    modifier: Modifier = Modifier,
    goBack: () -> Boolean,
    image: ImageData
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
                        text = SidePanelDestination.COMPONENT_IMAGE.label,
                        style = Typography.bodySmall
                    )
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

            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "Name: ${image.name}",
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "Url: ${image.url}",
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "Scale: ${(image.scale*100).toInt()}%",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}