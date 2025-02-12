package com.kingfuspace.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.Variables.isSmallScreen
import com.kingfuspace.main.ui.theme.typography
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.kingfuspace_logo_no_background
import org.jetbrains.compose.resources.painterResource


@Composable
fun Header(modifier: Modifier = Modifier) {
    val title = "Introducing Kingfuspace"
    val subtitle = "Create your platform with cutting-edge technology"
    val painter = painterResource(resource = Res.drawable.kingfuspace_logo_no_background)

    if (isSmallScreen) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(painter = painter)

            Spacer(modifier = Modifier.height(height = 16.dp))

            Text(
                title = title,
                subtitle = subtitle
            )
        }
    } else {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.weight(weight = 1f),
                painter = painter
            )

            Text(
                modifier = Modifier.weight(weight = 1f),
                title = title,
                subtitle = subtitle,
            )
        }
    }
}

@Composable
private fun Text(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = typography.headlineMedium
        )
        Text(
            text = subtitle,
            style = typography.displayMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun Image(
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = null
    )
}



