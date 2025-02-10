package com.kingfuspace.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.Variables.isSmallScreen
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.weatherai
import org.jetbrains.compose.resources.painterResource


@Composable
fun Weatherai(
    modifier: Modifier = Modifier
) {
    val title = "WeatherAI"
    val subTitle = "Android Application"
    val body =
        "WeatherAI is a sleek weather app offering accurate 7-day forecasts and hourly updates. AI-powered " +
                "weather answers from ChatGPT, and unique wallpapers created by AI."
    val url = "https://play.google.com/store/apps/details?id=com.kingfu.weatherai&hl=en_US"
    val uriHandler = LocalUriHandler.current


    if (isSmallScreen) {
        Column(modifier = modifier) {
            Box(
                modifier = Modifier.heightIn(max = 250.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.clip(shape = MaterialTheme.shapes.small),
                    painter = painterResource(Res.drawable.weatherai),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(height = 16.dp))

            Column {
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
                        Text(
                            text = "View",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    } else {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .heightIn(max = 300.dp)
                        .clip(shape = MaterialTheme.shapes.small),
                    painter = painterResource(resource = Res.drawable.weatherai),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(width = 16.dp))

            Column(
                modifier = Modifier
                    .weight(weight = 1f)
                    .fillMaxSize()
                    .padding(all = 24.dp),
                verticalArrangement = Arrangement.Center,
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
                        Text(
                            text = "View",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}