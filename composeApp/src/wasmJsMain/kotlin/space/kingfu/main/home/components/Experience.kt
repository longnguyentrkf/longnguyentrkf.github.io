package space.kingfu.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import space.kingfu.main.ui.theme.Typography


@Composable
fun Experience(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String,
    maxWidth: Float,
    titleFontSize: TextUnit = Typography.titleSmall.fontSize * space.kingfu.main.core.fontScale(
        float = maxWidth
    ),
    titleLineHeight: TextUnit = Typography.titleSmall.lineHeight * space.kingfu.main.core.fontScale(
        float = maxWidth
    ),
    subTitleFontSize: TextUnit = Typography.bodyMedium.fontSize * space.kingfu.main.core.fontScale(
        float = maxWidth
    ),
    subTitleLineHeight: TextUnit = Typography.bodyMedium.lineHeight * space.kingfu.main.core.fontScale(
        float = maxWidth
    ),
    bodyFontSize: TextUnit = Typography.bodyMedium.fontSize * space.kingfu.main.core.fontScale(
        float = maxWidth
    ),
    bodyLineHeight: TextUnit = Typography.bodyMedium.lineHeight * space.kingfu.main.core.fontScale(
        float = maxWidth
    )
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
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
