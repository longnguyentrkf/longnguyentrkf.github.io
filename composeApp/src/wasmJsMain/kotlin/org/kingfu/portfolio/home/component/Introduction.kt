package org.kingfu.portfolio.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.longnguyen
import kotlin.math.log10

@Composable
fun Introduction(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        propagateMinConstraints = true
    ) {
        val maxWidth = this.maxWidth
        val introduction = "Hello, I am Long Nguyen"
        val scaleMultiplier =
            log10((maxWidth.value + 10).coerceIn(1f, 1000f)) * 0.25f // Adjust 0.2f as needed
        val introductionFontSize = 42.sp * scaleMultiplier
        val introductionLineHeight = 52.sp * scaleMultiplier
        val whatIDo = "A software engineer and graphic designer based in California"
        val whatIDoFontSize = 62.sp * scaleMultiplier
        val whatIDoLineHeight = 72.sp * scaleMultiplier
        val scale = 1f
        val aspectRatio = 1f
        val resource = Res.drawable.longnguyen
        val uriHandler = LocalUriHandler.current
        val linkedInUrl = "https://www.linkedin.com/in/longnguyentrkf/"
        val linkedIn = "LinkedIn"


        if (maxWidth <= 700.dp) {
            Column(
                modifier = Modifier
                    .height(intrinsicSize = IntrinsicSize.Max)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(space = 24.dp)
            ) {
                Image(
                    modifier = Modifier
                        .scale(scale = scale)
                        .aspectRatio(ratio = aspectRatio),
                    painter = painterResource(resource = resource),
                    contentDescription = null
                )

                Column(modifier = Modifier.fillMaxWidth()) {
                    TextBodyLarge(
                        text = introduction,
                        fontSize = introductionFontSize,
                        lineHeight = introductionLineHeight,
                    )

                    Spacer(modifier = Modifier.height(height = 16.dp))

                    TextBodyLarge(
                        text = whatIDo,
                        fontSize = whatIDoFontSize,
                        lineHeight = whatIDoLineHeight,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(height = 16.dp))

                    OutlinedButton(
                        onClick = { uriHandler.openUri(uri = linkedInUrl) }
                    ) {
                        TextBodyLarge(
                            text = linkedIn,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .scale(scale = scale)
                        .aspectRatio(ratio = aspectRatio)
                        .weight(weight = 0.5f),
                    painter = painterResource(resource = resource),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(width = 16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(weight = 0.5f)
                ) {
                    TextBodyLarge(
                        text = introduction,
                        fontSize = introductionFontSize,
                        lineHeight = introductionLineHeight,
                    )

                    Spacer(modifier = Modifier.height(height = 16.dp))

                    TextBodyLarge(
                        text = whatIDo,
                        fontSize = whatIDoFontSize,
                        lineHeight = whatIDoLineHeight,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(height = 16.dp))

                    OutlinedButton(
                        onClick = { uriHandler.openUri(uri = linkedInUrl) }
                    ) {
                        TextBodyLarge(
                            text = linkedIn,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }

}