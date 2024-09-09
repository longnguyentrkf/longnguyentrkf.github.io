package space.kingfu.webpage.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import space.kingfu.webpage.ui.theme.Space


@Composable
fun MyOutLinedButtonRow(
    modifier: Modifier = Modifier,
    arrangement: Arrangement.Horizontal = Arrangement.spacedBy(space = Space().small_8),
    pair: List<Pair<String, String>>
) {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(state = scrollState),
        horizontalArrangement = arrangement,
    ) {
        pair.forEachIndexed { _, pair ->
            OutlinedButton(
                onClick = { uriHandler.openUri(uri = pair.second) }
            ) {
                Text(text = pair.first)
            }
        }
    }
}