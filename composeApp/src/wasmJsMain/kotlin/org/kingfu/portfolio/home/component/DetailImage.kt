package org.kingfu.portfolio.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.kingfu.portfolio.core.ScaleMultiplier
import org.kingfu.portfolio.ui.theme.Shape

@Composable
fun DetailImage(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String,
    resource: DrawableResource,
    buttonText: String,
    buttonAction: () -> Unit,
    titleFontSize: TextUnit = 42.sp,
    titleLineHeight: TextUnit = 52.sp,
    subTitleFontSize: TextUnit = 24.sp,
    subTitleLineHeight: TextUnit = 34.sp,
    bodyFontSize: TextUnit = 24.sp,
    bodyLineHeight: TextUnit = 34.sp,
    downloadFontSize: TextUnit = 16.sp,
    downloadLineHeight: TextUnit = 26.sp,
    width: Float = 1024f,
    height: Float = 500f,
    shape: Shape = Shape.medium
) {
    BoxWithConstraints(
        modifier = modifier.padding(horizontal = 16.dp),
        propagateMinConstraints = true
    ) {
        val multiplier = ScaleMultiplier(float = maxWidth.value)



        if (maxWidth <= 700.dp) {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = shape)
                        .aspectRatio(ratio = width / height)
                        .size(width = width.dp, height = height.dp),
                    painter = painterResource(resource = resource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Column {
                    TextBodyLarge(
                        text = title,
                        fontSize = titleFontSize * multiplier,
                        lineHeight = titleLineHeight * multiplier,
                    )

                    Spacer(modifier = Modifier.height(height = 8.dp))

                    TextBodyLarge(
                        text = subTitle,
                        fontSize = subTitleFontSize * multiplier,
                        lineHeight = subTitleLineHeight * multiplier
                    )

                    Spacer(modifier = Modifier.height(height = 32.dp))

                    TextBodyLarge(
                        text = body,
                        fontSize = bodyFontSize * multiplier,
                        lineHeight = bodyLineHeight * multiplier
                    )

                    Spacer(modifier = Modifier.height(height = 32.dp))

                    OutlinedButton(onClick = buttonAction) {
                        TextBodyLarge(
                            text = buttonText,
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


                Column(modifier = Modifier.weight(weight = 0.5f)) {
                    TextBodyLarge(
                        text = title,
                        fontSize = titleFontSize * multiplier,
                        lineHeight = titleLineHeight * multiplier,
                    )

                    Spacer(modifier = Modifier.height(height = 8.dp))

                    TextBodyLarge(
                        text = subTitle,
                        fontSize = subTitleFontSize * multiplier,
                        lineHeight = subTitleLineHeight * multiplier
                    )

                    Spacer(modifier = Modifier.height(height = 32.dp))

                    TextBodyLarge(
                        text = body,
                        fontSize = bodyFontSize * multiplier,
                        lineHeight = bodyLineHeight * multiplier
                    )

                    Spacer(modifier = Modifier.height(height = 32.dp))

                    OutlinedButton(onClick = buttonAction) {
                        TextBodyLarge(
                            text = buttonText,
                            fontSize = downloadFontSize,
                            lineHeight = downloadLineHeight
                        )
                    }
                }

                Spacer(modifier = Modifier.width(width = 32.dp))

                Image(
                    modifier = Modifier
                        .weight(weight = 0.5f)
                        .clip(shape = shape)
                        .aspectRatio(ratio = width / height)
                        .size(width = width.dp, height = height.dp),
                    painter = painterResource(resource = resource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}