package org.kingfu.portfolio.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import org.kingfu.portfolio.core.fontScale
import org.kingfu.portfolio.ui.theme.Space
import org.kingfu.portfolio.ui.theme.Typography


@Composable
fun Experience(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String,
    maxWidth: Float,
    titleFontSize: TextUnit = Typography.titleSmall.fontSize * fontScale(float = maxWidth),
    titleLineHeight: TextUnit = Typography.titleSmall.lineHeight * fontScale(float = maxWidth),
    subTitleFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale(float = maxWidth),
    subTitleLineHeight: TextUnit = Typography.bodyMedium.lineHeight * fontScale(float = maxWidth),
    bodyFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale(float = maxWidth),
    bodyLineHeight: TextUnit = Typography.bodyMedium.lineHeight * fontScale(float = maxWidth)
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = Space().medium_16)
    ) {

        Text(
            text = title,
            fontSize = titleFontSize,
            lineHeight = titleLineHeight
        )

        Text(
            text = subTitle,
            fontSize = subTitleFontSize,
            lineHeight = subTitleLineHeight
        )


        Text(
            text = body,
            fontSize = bodyFontSize,
            lineHeight = bodyLineHeight
        )
    }
}
