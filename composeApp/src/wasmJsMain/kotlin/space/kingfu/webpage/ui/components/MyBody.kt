package space.kingfu.webpage.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun MyBody(
    modifier: Modifier = Modifier,
    body: String,
    style: TextStyle = Typography.bodySmall,
    textAlign: TextAlign = TextAlign.Justify,
//    maxLines: Int = 2000
) {
    Text(
//        modifier = modifier.fillMaxWidth(),
        modifier = modifier,
        text = body,
        style = style,
        textAlign = textAlign,
//        maxLines = maxLines,


    )
}