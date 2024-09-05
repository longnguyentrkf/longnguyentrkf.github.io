package space.kingfu.webpage.topBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    iconContainerColor: Color = Transparent,
    titleOnClick: () -> Unit = {},
    navigationIconOnClick: () -> Unit = {}
) {

    TopAppBar(
        scrollBehavior = scrollBehavior,
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (title != null) {
                    Text(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable { titleOnClick() }
                            .padding(
                                vertical = Space().small_8,
                                horizontal = Space().medium_16
                            ),
                        text = title,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = Typography.bodySmall
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = iconContainerColor
                ),
                onClick = navigationIconOnClick
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Transparent
                ),
                onClick = {},
                enabled = false
            ) {
                Icon(
                    modifier = Modifier.alpha(alpha = 0f),
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        }
    )
}



