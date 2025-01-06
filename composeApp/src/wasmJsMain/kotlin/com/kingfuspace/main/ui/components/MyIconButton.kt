package com.kingfuspace.main.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun MyIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    containerColor: Color = Transparent,
    onClick: () -> Unit,
    contentDescription: String? = null,
    size: Dp = 48.dp
) {
    IconButton(
        modifier = modifier.size(size = size),
        colors = IconButtonDefaults
            .iconButtonColors(
                containerColor = containerColor
            ),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}