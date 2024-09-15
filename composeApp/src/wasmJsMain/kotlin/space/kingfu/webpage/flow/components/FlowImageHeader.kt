package space.kingfu.webpage.flow.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.longnguyen
import org.jetbrains.compose.resources.imageResource
import space.kingfu.webpage.flow.viewModel.ImageData
import space.kingfu.webpage.ui.components.MyImage
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun FlowImageHeader(
    modifier: Modifier = Modifier,
    setImage: (imageData: ImageData) -> Unit,
    image: ImageData
) {
    Column(modifier = modifier) {
        MyImage(
            width = 500.dp,
            height = 500.dp,
            url = image.url,
//            resource =  Res.drawable.longnguyen,
            onClick = {
                setImage(
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
                    .height(height = 40.dp),
                value = image.url,
                placeholder = "url",
                onValueChange = {
                    setImage(
                        ImageData(
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