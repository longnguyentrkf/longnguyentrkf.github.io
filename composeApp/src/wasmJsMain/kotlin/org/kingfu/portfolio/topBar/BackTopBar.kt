package org.kingfu.portfolio.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import com.kingfu.imaginate.ui.theme.TextBodyLarge


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    goBack: () -> Unit,
    containerColor: Color = Transparent,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    iconContainerColor: Color = Transparent
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor
        ),
        title = { if (title != null) TextBodyLarge(text = title) },
        navigationIcon = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = iconContainerColor
                ),
                onClick = goBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null
                )
            }

        }
    )
}

