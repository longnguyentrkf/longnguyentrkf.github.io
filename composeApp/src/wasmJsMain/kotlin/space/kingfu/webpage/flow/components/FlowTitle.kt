package space.kingfu.webpage.flow.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.Banner
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.components.MyTitle
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun FlowTitle(
    modifier: Modifier = Modifier,
    index: Int,
    setTitle: (index: Int, textData: TextData) -> Unit,
    banner: Banner
) {
    Column(modifier = modifier) {
        if (banner.title.isEdit) {
            MyTextField(
                modifier = Modifier.padding(vertical = 4.dp),
                value = banner.title.text,
                placeholder = "title",
                onValueChange = { setTitle(index, TextData(isEdit = true, text = it)) },
                contentAlignment = Alignment.Center,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                done = { setTitle(index, TextData(isEdit = false, text = banner.title.text)) },
                textAlign = TextAlign.Center
            )
        } else {
            MyTitle(
                modifier = Modifier
                    .padding(vertical = if (banner.title.text.isBlank()) 4.dp else 0.dp)
                    .clickable { setTitle(index, TextData(isEdit = true, text = banner.title.text)) }
                    .background(
                        if (banner.title.text.isBlank()) {
                            colorScheme.surfaceContainer
                        } else {
                            Transparent
                        },
                        shape = Shape.extraSmall
                    ),
                title = banner.title.text
            )
        }
    }
}