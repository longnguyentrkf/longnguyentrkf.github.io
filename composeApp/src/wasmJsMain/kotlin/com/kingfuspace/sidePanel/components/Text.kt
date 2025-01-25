package com.kingfuspace.sidePanel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.editor.state.TextData
import com.kingfuspace.sidePanel.ui.components.menu.BannerMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentText(
    modifier: Modifier = Modifier,
    goBack: () -> Boolean,
    text: TextData,
    goToSetTextName: () -> Unit
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
                            text = text.name,
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
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Text: ${text.text}",
                style = typography.labelMedium
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Font size: ${text.style.fontSize.value.toInt()}",
                style = typography.labelMedium
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Clickable: ${text.isClickable}",
                style = typography.labelMedium
            )
        }
    }
}