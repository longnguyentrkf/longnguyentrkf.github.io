package com.kingfuspace.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.core.Variables.isSmallScreen
import com.kingfuspace.main.core.Variables.windowInnerHeight
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.kingfuspace_logo_no_background
import org.jetbrains.compose.resources.painterResource


@Composable
fun Header(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    val introduction = "Introducing Kingfuspace"
    val description = "Create your platform with cutting-edge technology"
    val painter = painterResource(resource = Res.drawable.kingfuspace_logo_no_background)


    if (isSmallScreen) {
        Column(modifier = modifier) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.padding(all = 24.dp),
                    painter = painter,
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 24.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = introduction,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    } else {
        Row(
            modifier = modifier.height(
                height = (windowInnerHeight.dp - paddingValues.calculateTopPadding()).coerceAtLeast(
                    minimumValue = 0.dp
                )
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(weight = 1f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .matchParentSize()
                        .scale(scale = 0.5f),
                    painter = painter,
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .weight(weight = 1f)
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = introduction,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }


}