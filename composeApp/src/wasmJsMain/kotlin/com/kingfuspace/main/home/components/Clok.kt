package com.kingfuspace.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import kingfuspace.composeapp.generated.resources.clok
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun Clok(modifier: Modifier = Modifier) {
    val title = "Clok"
    val subtitle = "Android Application"
    val body = "Clok is a versatile time management app that combines a Stopwatch and Timer with " +
            "automatic data saving. Its user-friendly design adapts to your device’s theme, tracks laps, " +
            "and enhances productivity with smooth performance."
    val url = "https://play.google.com/store/apps/details?id=com.kingfu.clok&hl=en_US&pli=1"
    val uriHandler = LocalUriHandler.current

    if (isSmallScreen) {
        Column(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 300.dp)
                    .clip(shape = shapes.extraLarge)
            )

            Spacer(modifier = Modifier.height(height = 24.dp))

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
            Text(
                modifier = Modifier.weight(weight = 1f),
                title = title,
                subTitle = subtitle,
                body = body,
                url = url,
                uriHandler = uriHandler,
            )

            Spacer(modifier = Modifier.width(width = 24.dp))

            Image(
                modifier = Modifier
//                    .padding(all = 16.dp)
                    .weight(weight = 1f)
                    .heightIn(max = 300.dp)
                    .clip(shape = shapes.extraLarge)
            )
        }
    }
}

@Composable
private fun Image(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(resource = Res.drawable.clok),
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

