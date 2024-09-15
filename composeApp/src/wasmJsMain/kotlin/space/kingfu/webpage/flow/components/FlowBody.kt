package space.kingfu.webpage.flow.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.Banner
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.components.MyBody
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun FlowBody(
    modifier: Modifier = Modifier,
    body: TextData,
    index: Int,
    setBody: (index: Int, textData: TextData) -> Unit
) {
    Column(modifier = modifier) {
        if (body.isEdit) {
            MyTextField(
                modifier = Modifier.padding(vertical = 4.dp),
                value = body.text,
                placeholder = "body",
                onValueChange = { setBody(index, TextData(isEdit = true, text = it)) },
                contentAlignment = Alignment.TopStart,
                style = Typography.bodySmall,
                done = { setBody(index, TextData(isEdit = false, text = body.text)) },
                textAlign = TextAlign.Justify,
                maxChar = 500
            )
        } else {
            MyBody(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = if (body.text.isBlank()) 4.dp else 0.dp)
                    .clickable { setBody(index, TextData(isEdit = true, text = body.text)) }
                    .background(
                        color = if (body.text.isBlank()) colorScheme.surfaceContainer else Transparent,
                        shape = Shape.extraSmall
                    ),
                body = body.text
            )
        }
    }
}