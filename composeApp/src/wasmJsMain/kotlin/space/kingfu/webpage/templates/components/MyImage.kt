package space.kingfu.webpage.templates.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun MyImage(
    modifier: Modifier = Modifier,
    width: Dp = 1024.dp,
    height: Dp = 500.dp,
//    height: Dp = 1024.dp,
    shape: Shape = Shape.medium,
    contentScale: ContentScale = ContentScale.Crop,
    url: String?
) {
    val imageModifier = modifier
        .fillMaxSize()
        .clip(shape = shape)
        .aspectRatio(ratio = width.value / height.value)
        .size(width = width, height = height)

    if (url != null) {
        AsyncImage(
            modifier = imageModifier,
            model = url,
            contentDescription = null,
            contentScale = contentScale
        )
    } else {
        Box(
            modifier = imageModifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Add an image",
                style = Typography.bodyMedium
            )
        }
    }
}