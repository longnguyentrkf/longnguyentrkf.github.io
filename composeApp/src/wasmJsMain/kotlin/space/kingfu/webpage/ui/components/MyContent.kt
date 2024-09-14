package space.kingfu.webpage.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun MyContent(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    body: String? = null,
    footer: String? = null,
    buttons: @Composable (() -> Unit)? = null
) {
    Column {
        if(title != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        if(subtitle != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = subtitle,
                style = Typography.bodySmall,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center
            )
        }

//        Spacer(modifier = Modifier.height(height = 24.dp))

        if(body != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = body,
                style = Typography.bodySmall,
                textAlign = TextAlign.Justify
            )
        }

//        Spacer(modifier = Modifier.height(height = 24.dp))

        if(footer != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Explore Beyond the Horizon — Unlock your potential with a vision that extends beyond limits.",
                style = Typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            )
        }

//        Spacer(modifier = Modifier.height(height = 24.dp))

//        OutlinedButton(
//            onClick = {
//                val url =
//                    "https://play.google.com/store/apps/details?id=com.kingfu.aigallery&hl=en_US"
//                uriHandler.openUri(uri = url)
//            }
//        ) {
//            Text(
//                text = "Download",
//                style = Typography.bodySmall
//            )
//        }
    }
}