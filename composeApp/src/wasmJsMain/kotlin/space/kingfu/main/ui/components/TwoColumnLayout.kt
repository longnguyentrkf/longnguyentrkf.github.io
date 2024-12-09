package space.kingfu.main.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TwoColumnLayout(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit = {},
    right: @Composable () -> Unit = {},
    leftWeight: Float = 1f,
    rightWeight: Float = 1f,
    isReverseLayout: Boolean = false,
//    padding: Dp = 24.dp,
    isSmallScreen: Boolean
) {
    if (isSmallScreen) {
//        Column(modifier = modifier.padding(all = padding)) {
        Column {
            Column(
                modifier = Modifier
                    .weight(weight = leftWeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                left()
            }

//            Spacer(modifier = modifier.height(height = padding))

            Column(
                modifier = Modifier
                    .weight(weight = rightWeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                right()
            }
        }
    } else {
        Row(
            modifier = modifier
                .height(intrinsicSize = IntrinsicSize.Max)
//                .padding(all = padding)
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = leftWeight)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                if (isReverseLayout) right() else left()
            }

//            Spacer(modifier = modifier.width(width = padding))

            Column(
                modifier = Modifier
                    .weight(weight = rightWeight)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                if (isReverseLayout) left() else right()
            }
        }
    }
}


