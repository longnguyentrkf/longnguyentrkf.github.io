package space.kingfu.webpage.topBar

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import space.kingfu.webpage.ui.theme.ThemeType
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    iconContainerColor: Color = Transparent,
    theme: ThemeType,
    setTheme: (ThemeType) -> Unit,
    scrollState: ScrollState
) {
    val scope = rememberCoroutineScope()

    TopAppBar(
        scrollBehavior = scrollBehavior,
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(),
        title = {
            if (title != null) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .clickable {
                                scope.launch {
                                    scrollState.animateScrollTo(value = 0)
                                }
                            }
                            .padding(vertical = 8.dp, horizontal = 16.dp),
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
                onClick = { setTheme(if (theme == ThemeType.LIGHT) ThemeType.DARK else ThemeType.LIGHT) }
            ) {
                Icon(
                    imageVector = if (theme == ThemeType.LIGHT) Icons.Default.Bedtime else Icons.Default.LightMode,
                    contentDescription = null
                )
            }
        },
        actions = {
            OutlinedButton(
                modifier = Modifier.padding(end = 8.dp),
                onClick = {
                    scope.launch {
                        scrollState.animateScrollTo(value = scrollState.maxValue)
                    }
                }
            ) {
                Text(
                    text = "Hire me",
                    style = Typography.bodySmall
                )
            }
        }
    )
}



