package org.kingfu.portfolio.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.kingfu.portfolio.core.ScaleMultiplier


@Composable
fun Experience(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String
) {
    BoxWithConstraints(
        modifier = modifier,
        propagateMinConstraints = true
    ) {
        val multiplier = ScaleMultiplier(float = maxWidth.value)
        val titleFontSize = 42.sp * multiplier
        val titleLineHeight = 52.sp * multiplier
        val subTitleFontSize = 24.sp * multiplier
        val subTitleLineHeight = 34.sp * multiplier
        val bodyTitleFontSize = 24.sp * multiplier
        val bodyTitleLineHeight = 34.sp * multiplier

        Column(
            modifier = Modifier.padding(horizontal = if (maxWidth <= 700.dp) 16.dp else 32.dp),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {

            TextBodyLarge(
                text = title,
                fontSize = titleFontSize,
                lineHeight = titleLineHeight
            )

            TextBodyLarge(
                text = subTitle,
                fontSize = subTitleFontSize,
                lineHeight = subTitleLineHeight
            )

            TextBodyLarge(
                text = body,
                fontSize = bodyTitleFontSize,
                lineHeight = bodyTitleLineHeight
            )
        }
    }
}