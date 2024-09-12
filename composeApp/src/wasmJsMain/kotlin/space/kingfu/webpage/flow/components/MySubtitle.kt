package space.kingfu.webpage.flow.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun MySubtitle(
    modifier: Modifier = Modifier,
    subtitle: String,
    style: TextStyle = Typography.bodySmall,
    fontStyle: FontStyle = FontStyle.Italic,
    textAlign: TextAlign = TextAlign.Center
){
    Text(
        modifier = modifier.fillMaxWidth(),
        text = subtitle,
        style = style,
        fontStyle = fontStyle,
        textAlign = textAlign
    )
}