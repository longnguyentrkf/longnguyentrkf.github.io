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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.Banner
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.components.MySubtitle
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun FlowSubtitle(
    modifier: Modifier = Modifier,
    index: Int,
    setSubtitle: (index: Int, textData: TextData) -> Unit,
    subtitle: TextData
) {
    Column(modifier = modifier) {
        if (subtitle.isEdit) {
            MyTextField(
                modifier = Modifier.padding(vertical = 4.dp),
                value = subtitle.text,
                placeholder = "subtitle",
                onValueChange = { setSubtitle(index, TextData(isEdit = true, text = it)) },
                contentAlignment = Alignment.Center,
                style = Typography.bodySmall,
                done = { setSubtitle(index, TextData(isEdit = false, text = subtitle.text)) },
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )
        } else {
            MySubtitle(
                modifier = Modifier
                    .padding(vertical = if (subtitle.text.isBlank()) 4.dp else 0.dp)
                    .clickable { setSubtitle(index, TextData(isEdit = true, text = subtitle.text)) }
                    .background(
                        color = if (subtitle.text.isBlank()) colorScheme.surfaceContainer else Transparent,
                        shape = Shape.extraSmall
                    ),
                subtitle = subtitle.text
            )
        }
    }
}