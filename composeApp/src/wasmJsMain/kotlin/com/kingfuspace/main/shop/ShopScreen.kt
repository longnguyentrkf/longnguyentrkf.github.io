package com.kingfuspace.main.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.home.components.ImageDetail
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.kingfuspace_logo_no_background


@Composable
fun ShopScreen(
    modifier: Modifier = Modifier,
    isSmallScreen: Boolean
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 1200.dp)
                .padding(horizontal = 16.dp),
        ) {
            ImageDetail(
                modifier = Modifier.padding(all = 24.dp),
                title = "Webpage (Test Mode)",
                subTitle = "Price: $100",
                body = "A sleek designed webpage based on a template.",
                resource = Res.drawable.kingfuspace_logo_no_background,
                isSmallScreen = isSmallScreen
            )
        }
    }


}


