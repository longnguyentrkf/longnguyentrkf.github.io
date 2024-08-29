package org.kingfu.portfolio.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.jetbrains.compose.resources.painterResource
import org.kingfu.portfolio.ui.theme.Shape
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.kingfu
import kotlin.math.log10

@Composable
fun WhatIDo(modifier: Modifier = Modifier) {

    BoxWithConstraints(
        modifier = modifier.padding(horizontal = 16.dp),
        propagateMinConstraints = true
    ) {
        val maxWidth = this.maxWidth
        val title = "KingFu"
        val scaleMultiplier =
            log10((maxWidth.value + 10).coerceIn(1f, 1000f)) * 0.25f // Adjust 0.2f as needed
        val titleFontSize = 42.sp * scaleMultiplier
        val titleLineHeight = 52.sp * scaleMultiplier
        val subTitle = "• Web Developer\n• Brand Design\n• Logo Design\n• Native Android Engineer\n• Mentor"
        val subTitleFontSize = 24.sp * scaleMultiplier
        val subTitleLineHeight = 34.sp * scaleMultiplier
        val body = "Simple, elegant, productivity"
        val bodyFontSize = 24.sp * scaleMultiplier
        val bodyLineHeight = 34.sp * scaleMultiplier
        val shape = Shape.medium
        val resource = Res.drawable.kingfu
        val download = "View"
        val downloadFontSize = 16.sp
        val downloadLineHeight = 26.sp
        val uriHandler = LocalUriHandler.current
        val url = "https://play.google.com/store/apps/dev?id=6685291617439812065&hl=en_US"


        if (maxWidth <= 700.dp) {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = shape)
                        .aspectRatio(ratio = 256f / 125f)
                        .size(width = 1024.dp, height = 500.dp),
                    painter = painterResource(resource = resource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(space = 8.dp)
                ) {
                    TextBodyLarge(
                        text = title,
                        fontSize = titleFontSize,
                        lineHeight = titleLineHeight,
                    )

                    TextBodyLarge(
                        text = subTitle,
                        fontSize = subTitleFontSize,
                        lineHeight = subTitleLineHeight
                    )


                    TextBodyLarge(
                        text = body,
                        fontSize = bodyFontSize,
                        lineHeight = bodyLineHeight
                    )


                    OutlinedButton(
                        onClick = { uriHandler.openUri(uri = url) }
                    ) {
                        TextBodyLarge(
                            text = download,
                            fontSize = downloadFontSize,
                            lineHeight = downloadLineHeight
                        )
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .weight(weight = 0.5f)
                        .clip(shape = shape)
                        .aspectRatio(ratio = 256f / 125f)
                        .size(width = 1024.dp, height = 500.dp),
                    painter = painterResource(resource = resource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(width = 32.dp))

                Column(modifier = Modifier.weight(weight = 0.5f)) {
                    TextBodyLarge(
                        text = title,
                        fontSize = titleFontSize,
                        lineHeight = titleLineHeight,
                    )

                    Spacer(modifier = Modifier.height(height = 8.dp))

                    TextBodyLarge(
                        text = subTitle,
                        fontSize = subTitleFontSize,
                        lineHeight = subTitleLineHeight
                    )

                    Spacer(modifier = Modifier.height(height = 32.dp))

                    TextBodyLarge(
                        text = body,
                        fontSize = bodyFontSize,
                        lineHeight = bodyLineHeight
                    )

                    Spacer(modifier = Modifier.height(height = 32.dp))

                    OutlinedButton(
                        onClick = { uriHandler.openUri(uri = url) }
                    ) {
                        TextBodyLarge(
                            text = download,
                            fontSize = downloadFontSize,
                            lineHeight = downloadLineHeight
                        )
                    }
                }
            }
        }
    }
}