package com.kingfuspace.main.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import com.kingfuspace.main.ui.theme.Shape
import com.kingfuspace.main.ui.theme.Typography


@Composable
fun ImageDetail(
    modifier: Modifier = Modifier,
    title: String? = null,
    subTitle: String? = null,
    body: String? = null,
    resource: DrawableResource,
    width: Float = 1024f,
    height: Float = 500f,
    shape: Shape = Shape.medium,
    aspectRatio: Float = width / height,
    list: List<String> = listOf(),
    imageContentScale: ContentScale = Crop,
    isSmallScreen: Boolean,
) {
    val imageModifier = Modifier
        .clip(shape = shape)
        .aspectRatio(ratio = aspectRatio)
        .size(width = width.dp, height = height.dp)

//    if (isSmallScreen(width = maxWidth)) {
    if (isSmallScreen) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(space = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = imageModifier,
                painter = painterResource(resource = resource),
                contentDescription = null,
                contentScale = imageContentScale
            )

            Column(verticalArrangement = Arrangement.spacedBy(space = 32.dp)) {
                if (title != null || subTitle != null) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        if (title != null) {
                            Text(
                                text = title,
                                style = Typography.bodyLarge
                            )

                            Spacer(modifier = Modifier.height(height = 8.dp))

                        }

                        if (subTitle != null) {
                            Text(
                                text = subTitle,
                                style = Typography.bodySmall
                            )
                        }
                    }
                }

                if (body != null) {
                    Text(
                        text = body,
                        style = Typography.bodySmall
                    )
                }

                if (list.isNotEmpty()) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        for (item in list) {
                            Text(
                                text = "• $item",
                                style = Typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    } else {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = imageModifier.weight(weight = 0.5f),
                painter = painterResource(resource = resource),
                contentDescription = null,
                contentScale = imageContentScale
            )

            Spacer(modifier = Modifier.width(width = 32.dp))

            Column(
                modifier = Modifier.weight(weight = 0.5f),
                verticalArrangement = Arrangement.spacedBy(space = 32.dp)
            ) {
                if (title != null || subTitle != null) {
                    Column {
                        if (title != null) {
                            Text(
                                text = title,
                                style = Typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.height(height = 8.dp))

                        }

                        if (subTitle != null) {
                            Text(
                                text = subTitle,
                                style = Typography.bodySmall
                            )
                        }
                    }
                }

                if (body != null) {
                    Text(
                        text = body,
                        style = Typography.bodySmall
                    )
                }

                if (list.isNotEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
                    ) {
                        for (item in list) {
                            Text(
                                text = "• $item",
                                style = Typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
