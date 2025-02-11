package com.kingfuspace.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    val subTitle = "Web Page"
    val body = "A minimalistic designed web page detailing achievements, experiences, and services."
    val uriHandler = LocalUriHandler.current
    val url = "https://kingfuspace.com/longnguyen/"

    if (isSmallScreen) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            PortfolioImage()
            Spacer(modifier = Modifier.height(16.dp))
            PortfolioContent(title, subTitle, body, url, uriHandler)
        }
    } else {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PortfolioImage(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            PortfolioContent(title, subTitle, body, url, uriHandler, Modifier.weight(1f))
        }
    }
}

@Composable
private fun PortfolioImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .heightIn(max = 300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .fillMaxWidth(),
            painter = painterResource(resource = Res.drawable.longnguyen),
            contentDescription = null
        )
    }
}

@Composable
private fun PortfolioContent(
    title: String,
    subTitle: String,
    body: String,
    url: String,
    uriHandler: UriHandler,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.outline,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                shape = CircleShape,
                onClick = { uriHandler.openUri(uri = url) }
            ) {
                Text(text = "View", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
