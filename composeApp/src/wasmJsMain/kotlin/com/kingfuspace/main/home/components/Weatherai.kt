import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.Variables.isSmallScreen
import com.kingfuspace.main.ui.theme.typography
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.weatherai
import org.jetbrains.compose.resources.painterResource

@Composable
fun WeatherAI(modifier: Modifier = Modifier) {
    val title = "WeatherAI"
    val subtitle = "Android Application"
    val body = "WeatherAI is a sleek weather app offering accurate 7-day forecasts and hourly " +
            "updates. AI-powered weather answers from ChatGPT, and unique wallpapers created by AI."
    val url = "https://play.google.com/store/apps/details?id=com.kingfu.weatherai&hl=en_US"
    val uriHandler: UriHandler = LocalUriHandler.current

    if (isSmallScreen) {
        Column(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = shapes.extraSmall)
                    .heightIn(max = 300.dp)
            )

            Spacer(modifier = Modifier.height(height = 16.dp))

            Text(
                title = title,
                subTitle = subtitle,
                body = body,
                url = url,
                uriHandler = uriHandler
            )
        }
    } else {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .weight(weight = 1f)
                    .clip(shape = shapes.extraSmall)
                    .heightIn(max = 300.dp)
            )

            Spacer(modifier = Modifier.width(width = 16.dp))

            Text(
                modifier = Modifier
                    .weight(weight = 1f)
                    .fillMaxSize(),
                title = title,
                subTitle = subtitle,
                body = body,
                url = url,
                uriHandler = uriHandler
            )
        }
    }
}

@Composable
private fun Image(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(resource = Res.drawable.weatherai),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun Text(
    title: String,
    subTitle: String,
    body: String,
    url: String,
    uriHandler: UriHandler,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
    ) {
        Column {
            Text(
                text = title,
                style = typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = subTitle,
                style = typography.bodyLarge,
                color = colorScheme.outline,
                fontStyle = FontStyle.Italic
            )
        }

        Text(
            text = body,
            style = typography.bodyLarge,
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                onClick = { uriHandler.openUri(uri = url) }
            ) {
                Text(
                    text = "View",
                    style = typography.bodyLarge
                )
            }
        }
    }
}
