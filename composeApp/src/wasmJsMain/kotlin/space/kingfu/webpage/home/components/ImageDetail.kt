package space.kingfu.webpage.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale.Companion.Crop
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
fun ImageDetail(
    modifier: Modifier = Modifier,
    title: String? = null,
    subTitle: String? = null,
    body: String? = null,
    resource: DrawableResource,
    buttonText: String? = null,
    buttonAction: () -> Unit  = {},
    maxWidth: Dp,
    fontScale: Float = space.kingfu.webpage.core.fontScale(maxWidth.value),
    titleFontSize: TextUnit = Typography.titleSmall.fontSize * fontScale,
    titleLineHeight: TextUnit = Typography.titleSmall.lineHeight * fontScale,
    subTitleFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale,
    subTitleLineHeight: TextUnit = Typography.bodyMedium.lineHeight * fontScale,
    bodyFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale,
    bodyLineHeight: TextUnit = Typography.bodyMedium.lineHeight * fontScale,
    downloadFontSize: TextUnit = Typography.bodySmall.fontSize,
    downloadLineHeight: TextUnit = Typography.bodySmall.lineHeight,
    listFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale,
    width: Float = 1024f,
    height: Float = 500f,
    shape: Shape = Shape.medium,
    aspectRatio: Float = width / height,
    list: List<String> = listOf(),
    imageContentScale: ContentScale = Crop
) {
    val imageModifier = Modifier
        .clip(shape = shape)
        .aspectRatio(ratio = aspectRatio)
        .size(width = width.dp, height = height.dp)

    if (isSmallScreenWidth(maxWidth = maxWidth)) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(space = Space().large_32),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = imageModifier,
                painter = painterResource(resource = resource),
                contentDescription = null,
                contentScale = imageContentScale
            )

            Column(verticalArrangement = Arrangement.spacedBy(space = Space().large_32)) {
                if (title != null || subTitle != null) {
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
                                lineHeight = subTitleLineHeight,
                            )
                        }
                    }
                }

                if (body != null) {
                    Text(
                        text = body,
                        fontSize = bodyFontSize,
                        lineHeight = bodyLineHeight
                    )
                }

                if (list.isNotEmpty()) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        for (item in list) {
                            Text(
                                text = "• $item",
                                fontSize = listFontSize
                            )
                        }
                    }
                }

                if (buttonText != null) {
                    OutlinedButton(onClick = buttonAction) {
                        Text(
                            text = buttonText,
                            fontSize = downloadFontSize,
//                            lineHeight = downloadLineHeight
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
            Image(
                modifier = imageModifier.weight(weight = 0.5f),
                painter = painterResource(resource = resource),
                contentDescription = null,
                contentScale = imageContentScale
            )

            Spacer(modifier = Modifier.width(width = Space().large_32))

            Column(
                modifier = Modifier.weight(weight = 0.5f),
                verticalArrangement = Arrangement.spacedBy(space = Space().large_32)
            ) {
                if (title != null || subTitle != null) {
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
                                lineHeight = subTitleLineHeight,
                            )
                        }
                    }
                }


                if (body != null) {
                    Text(
                        text = body,
                        fontSize = bodyFontSize,
                        lineHeight = bodyLineHeight
                    )
                }


                if (list.isNotEmpty()) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        for (item in list) {
                            Text(
                                text = "• $item",
                                fontSize = listFontSize
                            )
                        }
                    }
                }

                if (buttonText != null) {
                    OutlinedButton(onClick = buttonAction) {
                        Text(
                            text = buttonText,
                            fontSize = downloadFontSize,
//                            lineHeight = downloadLineHeight
                        )
                    }
                }
            }
        }
    }
}
