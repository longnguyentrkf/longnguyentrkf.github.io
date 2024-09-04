package space.kingfu.webpage.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import space.kingfu.webpage.core.isSmallScreenWidth
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun DetailImage(
    modifier: Modifier = Modifier,
    title: String? = null,
    subTitle: String? = null,
    body: String? = null,
    resource: DrawableResource? = null,
    buttonText: String? = null,
    buttonAction: () -> Unit,
    maxWidth: Dp,
    fontScale: Float = space.kingfu.webpage.core.fontScale(float = maxWidth.value),
    titleFontSize: TextUnit = Typography.titleSmall.fontSize * fontScale,
    titleLineHeight: TextUnit = Typography.titleSmall.lineHeight * fontScale,
    subTitleFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale,
    subTitleLineHeight: TextUnit = Typography.bodyMedium.lineHeight * fontScale,
    bodyFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale,
    bodyLineHeight: TextUnit = Typography.bodyMedium.lineHeight * fontScale,
    downloadFontSize: TextUnit = Typography.bodySmall.fontSize,
    downloadLineHeight: TextUnit = Typography.bodySmall.lineHeight,
    width: Float = 1024f,
    height: Float = 500f,
    shape: Shape = Shape.medium
) {

    if (isSmallScreenWidth(maxWidth = maxWidth)) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(space = Space().large_32),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (resource != null) {
                Image(
                    modifier = Modifier
                        .clip(shape = shape)
                        .aspectRatio(ratio = width / height)
                        .size(width = width.dp, height = height.dp),
                    painter = painterResource(resource = resource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(space = Space().large_32)) {
                Column {
                    if (title != null) {
                        Text(
                            text = title,
                            fontSize = titleFontSize,
                            lineHeight = titleLineHeight,
                        )

                        Spacer(modifier = Modifier.height(height = Space().small_8))
                    }

                    if (subTitle != null) {
                        Text(
                            text = subTitle,
                            fontSize = subTitleFontSize,
                            lineHeight = subTitleLineHeight
                        )
                    }
                }

                if (body != null) {
                    Text(
                        text = body,
                        fontSize = bodyFontSize,
                        lineHeight = bodyLineHeight
                    )
                }

                if (buttonText != null) {
                    OutlinedButton(onClick = buttonAction) {
                        Text(
                            text = buttonText,
                            fontSize = downloadFontSize,
                            lineHeight = downloadLineHeight
                        )
                    }
                }
            }
        }
    } else {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(weight = 0.5f),
                verticalArrangement = Arrangement.spacedBy(space = Space().large_32)
            ) {
                Column {
                    if (title != null) {
                        Text(
                            text = title,
                            fontSize = titleFontSize,
                            lineHeight = titleLineHeight,
                        )

                        Spacer(modifier = Modifier.height(height = Space().small_8))
                    }

                    if (subTitle != null) {
                        Text(
                            text = subTitle,
                            fontSize = subTitleFontSize,
                            lineHeight = subTitleLineHeight
                        )
                    }
                }


                if (body != null) {
                    Text(
                        text = body,
                        fontSize = bodyFontSize,
                        lineHeight = bodyLineHeight
                    )
                }

                if (buttonText != null) {
                    OutlinedButton(onClick = buttonAction) {
                        Text(
                            text = buttonText,
                            fontSize = downloadFontSize,
                            lineHeight = downloadLineHeight
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(width = Space().large_32))

            if (resource != null) {
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
