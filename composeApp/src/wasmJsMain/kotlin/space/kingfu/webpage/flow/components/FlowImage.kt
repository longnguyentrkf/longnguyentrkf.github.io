package space.kingfu.webpage.flow.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.Banner
import space.kingfu.webpage.flow.viewModel.ImageData
import space.kingfu.webpage.ui.components.MyImage
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun FlowImage(
    modifier: Modifier = Modifier,
    index: Int,
    setImage: (index: Int, imageData: ImageData) -> Unit,
    banner: Banner
) {
    Column(modifier = modifier) {
        MyImage(
            url = banner.image.url,
            onClick = {
                setImage(index, ImageData(
                    isEdit = !banner.image.isEdit,
                    url = banner.image.url
                ))
            }
        )

        Spacer(modifier = Modifier.height(height = 12.dp))

        if (banner.image.isEdit) {
            MyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 40.dp),
                value = banner.image.url,
                placeholder = "url",
                onValueChange = {
                    setImage(index, ImageData(
                        isEdit = true,
                        url = it
                    ))
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