package space.kingfu.webpage.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import space.kingfu.webpage.ui.theme.Space


@Composable
fun MyOutLinedButtonRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
    arrangement: Arrangement.Horizontal = Arrangement.spacedBy(space = Space().small_8)
) {
    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(state = scrollState),
        horizontalArrangement = arrangement
    ) {
        content()
    }

}