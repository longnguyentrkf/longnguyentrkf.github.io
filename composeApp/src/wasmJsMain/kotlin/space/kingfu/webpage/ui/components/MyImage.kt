package space.kingfu.webpage.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import space.kingfu.webpage.ui.theme.Shape

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
    onClick: () -> Unit = {},
    backgroundColor: Color = colorScheme.surfaceContainer,
    resource: DrawableResource? = null
) {
    val imageModifier = modifier
        .clip(shape = shape)
        .background(
            color = if (url.isNullOrBlank() && resource == null) backgroundColor else Color.Transparent,
            shape = shape
        )
        .clickable { onClick() }
        .aspectRatio(ratio = width.value / height.value)
        .size(width = width, height = height)


    Box {
        if (resource != null) {
            Image(
                modifier = imageModifier,
                painter = painterResource(resource = resource),
                contentDescription = null
            )
        } else if (url != null) {
            AsyncImage(
                modifier = imageModifier,
                model = url,
                contentDescription = null,
                contentScale = contentScale
            )
        } else {
            Box(modifier = imageModifier.background(color = colorScheme.surfaceContainer)) {}
        }
        Box(modifier = imageModifier.zIndex(zIndex = -1f).background(color = colorScheme.surfaceContainer)) {}
    }
}

