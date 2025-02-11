package com.kingfuspace.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
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
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.imaginate
import org.jetbrains.compose.resources.painterResource


@Composable
fun Imaginate(modifier: Modifier = Modifier) {
    val title = "Imaginate"
    val subTitle = "Android Application"
    val body = "Imaginate brings creative innovation to life with AI-generated masterpieces that " +
            "you can download or set as wallpapers. Enjoy intuitive search, and customize your experience with themes."
    val url = "https://play.google.com/store/apps/details?id=com.kingfu.aigallery&hl=en_US"
    val uriHandler = LocalUriHandler.current

    if (isSmallScreen) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            ImaginateImage(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(height = 16.dp))
            ImaginateContent(
                title = title,
                subTitle = subTitle,
                body = body,
                url = url,
                uriHandler = uriHandler,
                modifier = Modifier.fillMaxWidth()
            )
        }
    } else {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImaginateContent(
                title = title,
                subTitle = subTitle,
                body = body,
                url = url,
                uriHandler = uriHandler,
                modifier = Modifier.weight(weight = 1f)
            )
            Spacer(modifier = Modifier.width(width = 16.dp))
            ImaginateImage(modifier = Modifier.weight(weight = 1f))
        }
    }
}

@Composable
fun ImaginateImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .heightIn(max = 300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.small)
                .fillMaxWidth(),
            painter = painterResource(resource = Res.drawable.imaginate),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ImaginateContent(
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

        Spacer(modifier = Modifier.height(height = 16.dp))

        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = Modifier.height(height = 16.dp))

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
