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
import com.kingfuspace.main.core.Variables.isSmallScreen
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.clok
import org.jetbrains.compose.resources.painterResource


@Composable
fun Clok(
    modifier: Modifier = Modifier
) {
    val title = "Clok"
    val subTitle = "Android Application"
    val body = "Clok is a versatile time management app that combines a Stopwatch and Timer with " +
            "automatic data saving. Its user-friendly " +
            "design adapts to your device’s theme, tracks laps, and enhances productivity with smooth performance."
    val url = "https://play.google.com/store/apps/details?id=com.kingfu.clok&hl=en_US&pli=1"
    val uriHandler = LocalUriHandler.current


    if (isSmallScreen) {
        Column(modifier = modifier.padding(vertical = 16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 250.dp)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.clip(shape = MaterialTheme.shapes.small),
                    painter = painterResource(Res.drawable.clok),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(height = 16.dp))


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
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
                    style = MaterialTheme.typography.bodyLarge
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
            modifier = modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 1f)
                    .fillMaxWidth()
                    .padding(all = 24.dp)
                ,
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

            Spacer(modifier = Modifier.width(width = 16.dp))

            Box(
                modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .heightIn(max = 300.dp)
                        .clip(shape = MaterialTheme.shapes.small),
                    painter = painterResource(resource = Res.drawable.clok),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}