package com.kingfuspace.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.Variables.isSmallScreen
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.longnguyen
import org.jetbrains.compose.resources.painterResource


@Composable
fun Portfolio(modifier: Modifier = Modifier) {

    val title = "Portfolio"
    val subtitle = "Web Page"
    val body = "A minimalistic designed web page detailing achievements, experiences, and services."
    val uriHandler = LocalUriHandler.current
    val url = "https://kingfuspace.com/longnguyen/"

    if (isSmallScreen) {
        Column(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = shapes.extraLarge)
                    .heightIn(max = 300.dp)
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
            Image(
                modifier = Modifier
                    .weight(weight = 1f)
                    .clip(shape = shapes.extraLarge)
                    .heightIn(max = 300.dp)
            )

            Spacer(modifier = Modifier.width(width = 24.dp))

            Text(
                modifier = Modifier.weight(weight = 1f),
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
        painter = painterResource(resource = Res.drawable.longnguyen),
        contentDescription = null
    )
}

@Composable
private fun Text(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    body: String,
    url: String,
    uriHandler: UriHandler
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
