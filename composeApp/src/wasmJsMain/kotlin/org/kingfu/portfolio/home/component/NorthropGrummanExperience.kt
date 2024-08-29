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
import kotlin.math.log10

@Composable
fun NorthropGrummanExperience(modifier: Modifier = Modifier) {

    BoxWithConstraints(
        modifier = modifier,
        propagateMinConstraints = true
    ) {
        val maxWidth = this.maxWidth
        val scaleMultiplier =
            log10((maxWidth.value + 10).coerceIn(1f, 1000f)) * 0.25f // Adjust 0.2f as needed
        val title = "Northrop Grumman"
        val titleFontSize = 42.sp * scaleMultiplier
        val titleLineHeight = 52.sp * scaleMultiplier
        val subTitle = "Software Engineer"
        val subTitleFontSize = 24.sp * scaleMultiplier
        val subTitleLineHeight = 34.sp * scaleMultiplier
        val body = "August 2020 - May 2021"
        val bodyTitleFontSize = 24.sp * scaleMultiplier
        val bodyTitleLineHeight = 34.sp * scaleMultiplier

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
