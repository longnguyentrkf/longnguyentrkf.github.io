package space.kingfu.webpage.templates.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.core.isSmallScreen

@Composable
fun TwoColumnLayout(
    modifier: Modifier = Modifier.padding(all = 24.dp),
    left: @Composable () -> Unit = {},
    right: @Composable () -> Unit = {},
    width: Dp,
    leftWeight: Float = 1f,
    rightWeight: Float = 1f,
    isSmallScreenReverseLayout: Boolean = false,
    isReverseLayout: Boolean = false
) {
    if (isSmallScreen(width = width)) {
        Column {
            Column(modifier = modifier) {
                if(isSmallScreenReverseLayout) right() else left()
            }
            Column(modifier = modifier) {
                if(isSmallScreenReverseLayout) left() else right()
            }
        }
    } else {
        Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
            Column(modifier = modifier.weight(weight = leftWeight)) {
                if(isReverseLayout) right () else left()
            }
            Column(modifier = modifier.weight(weight = rightWeight)) {
                if(isReverseLayout) left() else right()
            }
        }
    }

}

//@Composable
//fun ImageDetail2(
//    modifier: Modifier = Modifier.padding(all = 24.dp),
//    left: @Composable () -> Unit = {},
//    right: @Composable () -> Unit = {},
//    width: Dp,
//    leftWeight: Float = 1f,
//    rightWeight: Float = 1f,
//    isSmallScreenReverseLayout: Boolean = false,
//    isReverseLayout: Boolean = false
//) {
//    if (isSmallScreen(width = width)) {
//        Column {
//            Column(modifier = modifier) {
//                 left()
//            }
//            Column(modifier = modifier) {
//                 right()
//            }
//        }
//    } else {
//        Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
//            Column(modifier = modifier.weight(weight = leftWeight)) {
//                left()
//            }
//            Column(modifier = modifier.weight(weight = rightWeight)) {
//                right()
//            }
//        }
//    }
//
//}


