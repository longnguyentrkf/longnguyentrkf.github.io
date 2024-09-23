package space.kingfu.webpage.templates

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.flow
import org.jetbrains.compose.resources.painterResource
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TemplateScreen(goToPureFrame: () -> Unit) {

    val scrollState = rememberScrollState()
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.2f else 1f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
    )

    val alpha by animateFloatAsState(
        targetValue = if (isHovered) 0.8f else 0.5f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
    )
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .padding(all = 24.dp)
                .widthIn(max = 1200.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = Screen.Templates.name,
                style = Typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(height = 48.dp))

            FlowRow(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .height(height = 400.dp)
                        .width(width = 250.dp)
                        .clip(shape = Shape.medium)
                        .clickable { goToPureFrame() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.alpha(alpha = alpha)
                            .hoverable(interactionSource = interactionSource)
                            .scale(scale = scale),
                        painter = painterResource(resource = Res.drawable.flow),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .zIndex(zIndex = 1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = Screen.Flow.name,
                            style = Typography.bodyLarge,
                            color = colorScheme.inverseSurface
                        )
                    }
                }
            }
        }
    }
}

