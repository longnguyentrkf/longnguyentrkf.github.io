package space.kingfu.main.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import space.kingfu.main.core.isValidUrl
import space.kingfu.main.ui.theme.Shape




@Composable
fun MyImage(
    modifier: Modifier = Modifier,
    width: Dp = 1024.dp,
    height: Dp = 500.dp,
//    width: Dp = 500.dp,
//    height: Dp = 500.dp,
    shape: Shape = Shape.medium,
    contentScale: ContentScale = ContentScale.Crop,
    url: String? = null,
    onClick: (() -> Unit)? = null,
    backgroundColor: Color = colorScheme.surfaceContainer,
    drawableResource: DrawableResource? = null,
    scale: Float = 1f,
    isIcon: Boolean = false,
//    image: ImageData
) {
    val asyncImageModifier = modifier
        .scale(scale = scale)
        .clip(shape = shape)
        .background(
            color = if (!url.isValidUrl()) backgroundColor else Transparent,
            shape = shape
        )
        .clickable(enabled = onClick != null) {
            if (onClick != null) {
                onClick()
            }
        }
        .aspectRatio(ratio = width.value / height.value)
        .size(width = width, height = height)

    val imageModifier = modifier
        .clip(shape = shape)
        .scale(scale = scale)
        .aspectRatio(ratio = width.value / height.value)
        .size(width = width, height = height)


    if (drawableResource != null) {
        if (!isIcon) {
            Image(
                modifier = imageModifier,
                painter = painterResource(resource = drawableResource),
                contentDescription = null,
                contentScale = contentScale
            )
        } else {
            Icon(
                modifier = imageModifier,
                painter = painterResource(resource = drawableResource),
                contentDescription = null
            )
        }
    } else {
        Box {
            AsyncImage(
                modifier = asyncImageModifier,
                model = url,
                contentDescription = null,
                contentScale = contentScale
            )

            Box(modifier = asyncImageModifier)
        }
    }
}

