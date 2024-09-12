package space.kingfu.webpage.flow.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun MyFooter(
    modifier: Modifier = Modifier,
    footer: String,
    style: TextStyle = Typography.bodySmall,
    color: Color = colorScheme.outline,
    textAlign: TextAlign = TextAlign.Justify
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = footer,
        style = style,
        color = color,
        textAlign = textAlign
    )
}