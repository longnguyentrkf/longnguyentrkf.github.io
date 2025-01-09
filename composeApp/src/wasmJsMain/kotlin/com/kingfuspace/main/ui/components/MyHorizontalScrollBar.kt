package com.kingfuspace.main.ui.components

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.MyHorizontalScrollBar(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.BottomStart,
    lazyListState: LazyListState,
    unhoverColor: Color =  colorScheme.outlineVariant,
    hoverColor: Color = colorScheme.outlineVariant,
    minimalHeight: Dp = 24.dp,
    thickness: Dp = 12.dp,
    shape: Shape = CircleShape
) {
    HorizontalScrollbar(
        modifier = modifier.align(alignment = alignment),
        adapter = rememberScrollbarAdapter(scrollState = lazyListState),
        style = defaultScrollbarStyle().copy(
            thickness = thickness,
            unhoverColor = unhoverColor,
            hoverColor = hoverColor,
            minimalHeight = minimalHeight,
            shape = shape
        )
    )
}