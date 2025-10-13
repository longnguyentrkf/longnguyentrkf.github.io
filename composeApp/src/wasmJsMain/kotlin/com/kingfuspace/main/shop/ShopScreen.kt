package com.kingfuspace.main.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kingfuspace.main.ui.theme.KingFuTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.skia.Surface


@Composable
fun ShopScreen(
    modifier: Modifier = Modifier,
//    isSmallScreen: Boolean
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

    }


}

@Preview
@Composable
private fun PreviewShopScreen(){
    KingFuTheme {
        androidx.compose.material3.Surface{
            ShopScreen()
        }
    }
}



