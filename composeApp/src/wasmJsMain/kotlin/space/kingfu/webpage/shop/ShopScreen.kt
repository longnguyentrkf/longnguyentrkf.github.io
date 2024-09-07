package space.kingfu.webpage.shop

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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.kingfu_rectangle
import space.kingfu.webpage.home.components.ImageDetail
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun ShopScreen() {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val maxWidth = maxWidth
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .widthIn(max = 1200.dp)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(height = Space().xLarge_64))

            ImageDetail(
                title = "Webpage (Test Mode)",
                subTitle = "Price: $100",
                body = "A sleek designed webpage based on a template.",
                resource = Res.drawable.kingfu_rectangle,
                maxWidth = maxWidth,
                buttonList = {
                    OutlinedButton(
                        onClick = {
                            val url = "https://kingfu.space/longnguyen/"
                            uriHandler.openUri(uri = url)
                        }
                    ) {
                        Text(
                            text = "Preview template",
                            style = Typography.bodySmall
                        )
                    }

                    OutlinedButton(
                        onClick = {
                            val url = "https://buy.stripe.com/test_00geXs2H42xG6hadQR"
                            uriHandler.openUri(uri = url)
                        }
                    ) {
                        Text(
                            text = "Buy",
                            style = Typography.bodySmall
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(height = 1200.dp))

        }
    }
}


