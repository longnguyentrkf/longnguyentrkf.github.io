package space.kingfu.webpage.topBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.ThemeType
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    iconContainerColor: Color = Transparent,
    theme: ThemeType? = null,
    setTheme: (ThemeType) -> Unit = {},
    actionText: String? = null,
    actionOnClick: () -> Unit = {},
    titleOnClick: () -> Unit = {},
    titleIcon: DrawableResource? = null,
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
                Row(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .clickable { titleOnClick() }
                        .padding(vertical = Space().small_8, horizontal = Space().medium_16),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (titleIcon != null) {
                        Icon(
                            modifier = Modifier.size(size = 24.dp),
                            painter = painterResource(resource = titleIcon),
                            contentDescription = null,
                            tint = colorScheme.inverseSurface
                        )

                        Spacer(modifier = Modifier.width(width = 4.dp))
                    }

                    if (title != null) {

                        Text(
                            text = title,
                            modifier = Modifier,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            style = Typography.bodySmall
                        )
                    }
                }
            }
        },
        navigationIcon = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
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

                if(theme != null) {
                    IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = iconContainerColor
                        ),
                        onClick = { setTheme(theme) }
                    ) {
                        Icon(
                            imageVector = if (theme == ThemeType.LIGHT) Icons.Default.Bedtime else Icons.Default.LightMode,
                            contentDescription = null
                        )
                    }
                }
            }
        },
        actions = {
            if (actionText != null) {
                OutlinedButton(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = actionOnClick
                ) {
                    Text(
                        text = actionText,
                        style = Typography.bodySmall
                    )
                }
            }
        }
    )
}



