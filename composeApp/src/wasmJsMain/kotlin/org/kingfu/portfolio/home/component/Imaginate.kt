package org.kingfu.portfolio.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.jetbrains.compose.resources.painterResource
import org.kingfu.portfolio.ui.theme.Shape
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.imaginate
import kotlin.math.log10

@Composable
fun Imaginate(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxWidth()) {
        BoxWithConstraints(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            propagateMinConstraints = true
        ) {
            val maxWidth = this.maxWidth
            val title = "Imaginate"
            val scaleMultiplier =
                log10((maxWidth.value + 10).coerceIn(1f, 1000f)) * 0.25f // Adjust 0.2f as needed
            val titleFontSize = 42.sp * scaleMultiplier
            val titleLineHeight = 52.sp * scaleMultiplier
            val subTitle = "Android Application"
            val subTitleFontSize = 24.sp * scaleMultiplier
            val subTitleLineHeight = 34.sp * scaleMultiplier
            val body =
                "Imaginate, where creative innovation comes to life. Explore AI-generated masterpieces, " +
                        "download them, or set as wallpapers. Enjoy interactive features like zoom and pan, and " +
                        "discover new art through intuitive search. Customize your experience with themes, and stay tuned for exciting updates."
            val bodyFontSize = 24.sp * scaleMultiplier
            val bodyLineHeight = 34.sp * scaleMultiplier
            val shape = Shape.medium
            val scale = 1f
            val resource = Res.drawable.imaginate
            val fontWeight = FontWeight.Light
            val download = "Download"
            val downloadFontSize = 16.sp
            val downloadLineHeight = 26.sp
            val uriHandler = LocalUriHandler.current
            val imaginateUrl = "https://play.google.com/store/apps/details?id=com.kingfu.aigallery&hl=en_US"


            if (maxWidth <= 700.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(space = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .scale(scale = scale)
                            .clip(shape = shape),
                        painter = painterResource(resource = resource),
                        contentDescription = null
                    )

                    Column(modifier = Modifier.fillMaxWidth()) {
                        TextBodyLarge(
                            text = title,
                            fontSize = titleFontSize,
                            lineHeight = titleLineHeight,
                        )

                        Spacer(modifier = Modifier.height(height = 8.dp))

                        TextBodyLarge(
                            text = subTitle,
                            fontSize = subTitleFontSize,
                            lineHeight = subTitleLineHeight,
                            fontWeight = fontWeight
                        )

                        Spacer(modifier = Modifier.height(height = 32.dp))

                        TextBodyLarge(
                            text = body,
                            fontSize = bodyFontSize,
                            lineHeight = bodyLineHeight,
                            fontWeight = fontWeight
                        )

                        Spacer(modifier = Modifier.height(height = 32.dp))

                        OutlinedButton(
                            onClick = { uriHandler.openUri(uri = imaginateUrl) }
                        ) {
                            TextBodyLarge(
                                text = download,
                                fontSize = downloadFontSize,
                                lineHeight = downloadLineHeight,
                                fontWeight = fontWeight
                            )
                        }

                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(weight = 0.5f),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .scale(scale = scale)
                                .clip(shape = shape),
                            painter = painterResource(resource = resource),
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.width(width = 16.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(weight = 0.5f)
                    ) {
                        TextBodyLarge(
                            text = title,
                            fontSize = titleFontSize,
                            lineHeight = titleLineHeight,
                        )

                        Spacer(modifier = Modifier.height(height = 8.dp))

                        TextBodyLarge(
                            text = subTitle,
                            fontSize = subTitleFontSize,
                            lineHeight = subTitleLineHeight,
                            fontWeight = fontWeight
                        )

                        Spacer(modifier = Modifier.height(height = 32.dp))

                        TextBodyLarge(
                            text = body,
                            fontSize = bodyFontSize,
                            lineHeight = bodyLineHeight,
                            fontWeight = fontWeight
                        )

                        Spacer(modifier = Modifier.height(height = 32.dp))

                        OutlinedButton(
                            onClick = { uriHandler.openUri(uri = imaginateUrl) }
                        ) {
                            TextBodyLarge(
                                text = download,
                                fontSize = downloadFontSize,
                                lineHeight = downloadLineHeight,
                                fontWeight = fontWeight
                            )
                        }
                    }
                }
            }
        }
    }
}