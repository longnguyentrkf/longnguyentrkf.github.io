package com.kingfuspace.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.home.viewModel.Header
import com.kingfuspace.main.ui.components.MyImage
import com.kingfuspace.main.ui.components.TwoColumnLayout
import com.kingfuspace.main.ui.theme.Typography


@Composable
fun HeaderContent(
    modifier: Modifier = Modifier,
//    title1: String,
//    title2: String,
//    drawableResource: DrawableResource,
    header: Header,
    isSmallScreen: Boolean
) {
    TwoColumnLayout(
        modifier = modifier,
        isSmallScreen = isSmallScreen,
//        width = Variables.maxWidth,
        left = {
            MyImage(
                height = 1.dp,
                width = 1.dp,
                drawableResource = header.image,
                scale = 0.5f,
                contentScale = ContentScale.Fit,
                isIcon = true
            )
        },
        right = {
            Column(verticalArrangement = Arrangement.spacedBy(space = 12.dp)) {
                if (header.title1 != null) {
                    Text(
                        text = header.title1,
                        style = Typography.bodyLarge
                    )
                }


                if(header.title2 != null) {
                    Text(
                        text = header.title2,
                        style = Typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    )
}