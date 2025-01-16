package com.kingfuspace.main.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.browser.window

@Composable
fun TwoColumnLayout(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit = {},
    right: @Composable () -> Unit = {},
    leftWeight: Float = 1f,
    rightWeight: Float = 1f,
    isReverseLayout: Boolean = false,
    isSmallScreen: Boolean
) {
    if (isSmallScreen) {
        Column(modifier = modifier) {
            Column(
                modifier = Modifier
                    .weight(weight = leftWeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                left()
            }

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
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = leftWeight)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                if (isReverseLayout) right() else left()
            }

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


