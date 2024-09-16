package space.kingfu.webpage.flow.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.ImageData
import space.kingfu.webpage.ui.components.MyImage
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun FlowImage(
    modifier: Modifier = Modifier,
    index: Int,
    setImage: (index: Int, imageData: ImageData) -> Unit,
    image: ImageData
) {
    Column(modifier = modifier) {
        MyImage(
            url = image.url,
            onClick = {
                setImage(
                    index,
                    ImageData(
                        isEdit = !image.isEdit,
                        url = image.url
                    )
                )
            }
        )

        Spacer(modifier = Modifier.height(height = 12.dp))

        if (image.isEdit) {
            MyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = Shape.small)
                    .background(color = colorScheme.surfaceContainer)
                    .padding(start = 8.dp, end = 16.dp)
                    .height(height = 40.dp),
                value = image.url,
                placeholder = "url",
                onValueChange = {
                    setImage(
                        index, ImageData(
                            isEdit = true,
                            url = it
                        )
                    )
                },
                contentAlignment = Alignment.Center,
                style = Typography.bodySmall,
                textAlign = TextAlign.Center,
                maxChar = 500,
                isSingleLine = true
            )
        }
    }
}