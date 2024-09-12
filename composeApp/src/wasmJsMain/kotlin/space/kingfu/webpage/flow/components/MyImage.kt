package space.kingfu.webpage.flow.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.longnguyen
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
    url: String?,
) {
    val imageModifier = modifier
//        .fillMaxSize()
        .clip(shape = shape)
        .aspectRatio(ratio = width.value / height.value)
        .size(width = width, height = height)

    AsyncImage(
        modifier = imageModifier,
        model = url,
        contentDescription = null,
        contentScale = contentScale
    )


}