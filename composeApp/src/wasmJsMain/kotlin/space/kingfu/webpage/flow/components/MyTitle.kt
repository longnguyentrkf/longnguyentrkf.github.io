package space.kingfu.webpage.flow.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun MyTitle(
    modifier: Modifier = Modifier,
    title: String,
    style: TextStyle = Typography.bodyLarge,
    fontWeight: FontWeight = FontWeight.Bold,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = title,
        style = style,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}