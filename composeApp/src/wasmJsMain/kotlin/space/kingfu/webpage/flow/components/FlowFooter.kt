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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.components.MyFooter
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun FlowFooter(
    modifier: Modifier = Modifier,
    footer: TextData,
    index: Int,
    setFooter: (index: Int, textData: TextData) -> Unit
) {
    Column(modifier = modifier) {
        if (footer.isEdit) {
            MyTextField(
                modifier = Modifier.padding(vertical = 4.dp),
                value = footer.text,
                placeholder = "footer",
                onValueChange = { setFooter(index, TextData(isEdit = true, text = it)) },
                contentAlignment = Alignment.TopStart,
                style = Typography.bodySmall,
                done = { setFooter(index, TextData(isEdit = false, text = footer.text)) },
                textAlign = TextAlign.Justify,
                placeHolderColor = colorScheme.outline.copy(alpha = 0.5f),
                editTextColor = colorScheme.outline
            )
        } else {
            MyFooter(
                modifier = Modifier
                    .padding(vertical = if (footer.text.isBlank()) 4.dp else 0.dp)
                    .clickable { setFooter(index, TextData(isEdit = true, text = footer.text)) }
                    .background(
                        color = if (footer.text.isBlank()) colorScheme.surfaceContainer else Transparent,
                        shape = Shape.extraSmall
                    ),
                footer = footer.text,
                textAlign = TextAlign.Justify
            )
        }
    }
}