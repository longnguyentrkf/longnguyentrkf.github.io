package space.kingfu.webpage.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.imaginate
import kingfu.composeapp.generated.resources.weatherai
import space.kingfu.webpage.flow.model.Details
import space.kingfu.webpage.templates.components.MyBody
import space.kingfu.webpage.templates.components.MyFooter
import space.kingfu.webpage.templates.components.MyImage
import space.kingfu.webpage.templates.components.MySpace
import space.kingfu.webpage.templates.components.MySubtitle
import space.kingfu.webpage.templates.components.MyTitle
import space.kingfu.webpage.templates.components.TwoColumnLayout
import space.kingfu.webpage.ui.components.MyOutLinedButtonRow
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Typography
import kotlin.reflect.KFunction2


@Composable
fun FlowScreen(
    details: List<Details>,
    setTitleFirst: (Int, String) -> Unit,
    setTitleSecond: (Int, Boolean) -> Unit,
    addDetails: () -> Unit,
    setSubtitleFirst: (Int, String) -> Unit,
    setSubtitleSecond: (Int, Boolean) -> Unit,
) {

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val width = maxWidth

        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .widthIn(max = 1200.dp),
            verticalArrangement = Arrangement.spacedBy(space = 64.dp)
        ) {

            TwoColumnLayout(
                isSmallScreenReverseLayout = true,
                width = width,
                left = {
                    if (details[0].title.second) {
                        MyTextField(
                            modifier = Modifier.padding(vertical = 4.dp),
                            value = details[0].title.first,
                            placeholder = "title",
                            onValueChange = { setTitleFirst(0, it) },
                            contentAlignment = Alignment.Center,
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            done = { setTitleSecond(0, false) },
                            textAlign = TextAlign.Center
                        )
                    } else {
                        MyTitle(
                            modifier = Modifier
                                .padding(vertical = if(details[0].title.first.isBlank()) 4.dp else 0.dp)
                                .clickable { setTitleSecond(0, true) }
                                .background(
                                    if (details[0].title.first.isBlank()) colorScheme.inverseSurface.copy(alpha = 0.05f) else Transparent
                                ),
                            title = details[0].title.first
                        )
                    }

                    if(details[0].subtitle.second) {
                        MyTextField(
                            modifier = Modifier.padding(vertical = 4.dp),
                            value = details[0].subtitle.first,
                            placeholder = "subtitle",
                            onValueChange = { setSubtitleFirst(0, it) },
                            contentAlignment = Alignment.Center,
                            style = Typography.bodySmall,
                            done = { setSubtitleSecond(0, false) },
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Italic
                        )
                    }else{
                        MySubtitle(
                            modifier = Modifier
                                .padding(vertical = if(details[0].subtitle.first.isBlank()) 4.dp else 0.dp)
                                .clickable { setSubtitleSecond(0, true) }
                                .background(
                                    if (details[0].subtitle.first.isBlank()) colorScheme.inverseSurface.copy(alpha = 0.05f) else Transparent
                                ),
                            subtitle = details[0].subtitle.first
                        )
                    }

                    MySpace()
                    MyBody(
                        body = "This minimalist design represents the intersection of creativity and perspective. " +
                                "The triangle, grounded and solid, symbolizes the foundation of thought, while " +
                                "the circle represents boundless imagination. Together, they form a horizon—an ever-expanding " +
                                "space where ideas meet, grow, and evolve. It reflects the journey of transforming a vision " +
                                "into reality, where the geometric simplicity invites interpretation and deeper thought. The " +
                                "harmonious blend of shapes speaks to the balance between the known and the unknown, the tangible and the abstract."
                    )
                    MySpace()
                    MyFooter(footer = "Explore Beyond the Horizon — Unlock your potential with a vision that extends beyond limits.")
                    MySpace()
                    MyOutLinedButtonRow(
                        pair = listOf(
                            Pair(
                                "Download",
                                "https://play.google.com/store/apps/details?id=com.kingfu.aigallery&hl=en_US"
                            )
                        )
                    )
                },
                right = { MyImage(
                    modifier = Modifier.clickable {
                        println(details.size)
                    },
                    resource = Res.drawable.imaginate
                ) }
            )


            TwoColumnLayout(
                modifier = Modifier.padding(all = 24.dp),
                width = width,
                left = { MyImage(resource = Res.drawable.weatherai) },
                right = {
                    MyTitle(title = "Radiant Dreams")
                    MySubtitle(subtitle = "A World of Color Through her Eyes")
                    MySpace()
                    MyBody(
                        body = "In a world filled with endless colors and light, she sits quietly, lost in thought, " +
                                "gazing into the distance. Her expressive eyes reflect a universe of wonder, curiosity, " +
                                "and dreams yet to be explored. With a soft, delicate glow surrounding her, she embodies " +
                                "the essence of youthful innocence and the magic of imagination. Every shade, every sparkle, " +
                                "tells a story of a vibrant inner world that only she knows. This piece captures the beauty of " +
                                "those fleeting moments when reality blurs into fantasy.",
                    )
                    MySpace()
                    MyFooter(footer = "Explore the Colors of Emotion — Dive into a world where dreams and reality blend through the spectrum of light.")
                    MySpace()
                    MyOutLinedButtonRow(
                        pair = listOf(
                            Pair(
                                "Download",
                                "https://play.google.com/store/apps/details?id=com.kingfu.weatherai&hl=en_US"
                            )
                        )
                    )
                }
            )

            Spacer(modifier = Modifier.height(height = 600.dp))

        }
    }

}