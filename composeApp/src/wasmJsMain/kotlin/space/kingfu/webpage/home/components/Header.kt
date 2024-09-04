package space.kingfu.webpage.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import space.kingfu.webpage.ui.theme.Typography
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import space.kingfu.webpage.core.isSmallScreenWidth
import space.kingfu.webpage.ui.theme.Space


@Composable
fun Header(
    modifier: Modifier = Modifier,
    maxWidth: Dp,
    fontScale: Float = space.kingfu.webpage.core.fontScale(maxWidth.value),
    introductionFontSize: TextUnit = Typography.titleMedium.fontSize * fontScale,
    introductionLineHeight: TextUnit = Typography.titleMedium.lineHeight * fontScale,
    whatIDoFontSize: TextUnit = Typography.displaySmall.fontSize * fontScale,
    whatIDoLineHeight: TextUnit = Typography.displaySmall.lineHeight * fontScale,
    introduction: String? = null,
    whatIDo: String? = null,
    imageScale: Float = 1f,
    aspectRatio: Float = 1f,
    resource: DrawableResource,
    linkedInUrl: String? = null,
) {
    val uriHandler = LocalUriHandler.current
    val imageModifier = Modifier
        .scale(scale = imageScale)
        .aspectRatio(ratio = aspectRatio)


    if (isSmallScreenWidth(maxWidth = maxWidth)) {
        Column(
            modifier = modifier
                .height(intrinsicSize = IntrinsicSize.Max)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(space = Space().large_32)
        ) {
            Image(
                modifier = imageModifier,
                painter = painterResource(resource = resource),
                contentDescription = null
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(space = Space().medium_16)
            ) {
                if (introduction != null) {
                    Text(
                        text = introduction,
                        fontSize = introductionFontSize,
                        lineHeight = introductionLineHeight,
                    )
                }

                if (whatIDo != null) {
                    Text(
                        text = whatIDo,
                        fontSize = whatIDoFontSize,
                        lineHeight = whatIDoLineHeight,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (linkedInUrl != null) {
                    OutlinedButton(
                        onClick = { uriHandler.openUri(uri = linkedInUrl) }
                    ) {
                        Text(
                            text = "LinkedIn",
                            fontWeight = FontWeight.Bold,
                            style = Typography.bodySmall
                        )
                    }
                }
            }
        }
    } else {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = imageModifier.weight(weight = 0.5f),
                painter = painterResource(resource = resource),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(width = Space().medium_16))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 0.5f),
                verticalArrangement = Arrangement.spacedBy(space = Space().medium_16)
            ) {
                if (introduction != null) {
                    Text(
                        text = introduction,
                        fontSize = introductionFontSize,
                        lineHeight = introductionLineHeight,
                    )
                }

                if (whatIDo != null) {
                    Text(
                        text = whatIDo,
                        fontSize = whatIDoFontSize,
                        lineHeight = whatIDoLineHeight,
                        fontWeight = FontWeight.Bold,
                    )
                }


                if (linkedInUrl != null) {
                    OutlinedButton(
                        onClick = { uriHandler.openUri(uri = linkedInUrl) }
                    ) {
                        Text(
                            text = "LinkedIn",
                            fontWeight = FontWeight.Bold,
                            style = Typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}