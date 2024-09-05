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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.kingfu
import kingfu.composeapp.generated.resources.kingfu_rectangle
import space.kingfu.webpage.home.components.ImageDetail
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.topBar.MenuTopBar
import space.kingfu.webpage.ui.theme.Space


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen(
    toggleDrawer: () -> Unit
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val uriHandler = LocalUriHandler.current

    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            MenuTopBar(
                title = Screen.Shop.name,
                navigationIconOnClick = toggleDrawer,
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            val maxWidth = maxWidth
            Column(
                modifier = Modifier
                    .verticalScroll(state = scrollState)
                    .padding(paddingValues = it)
                    .widthIn(max = 1200.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.height(height = Space().xLarge_64))

                ImageDetail(
                    title = "Webpage (Test Mode)",
                    subTitle = "Web Application\nPrice: $100",
                    body = "A sleek designed webpage based on a template.",
                    buttonText = "Buy",
                    resource = Res.drawable.kingfu_rectangle,
                    buttonAction = {
                        val url = "https://buy.stripe.com/test_bIY9D81D05JS0WQ9AA"
                        uriHandler.openUri(uri = url)
                    },
                    maxWidth = maxWidth
                )

                Spacer(modifier = Modifier.height(height = 1200.dp))

            }
        }
    }
}