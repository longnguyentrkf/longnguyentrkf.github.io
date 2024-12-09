package space.kingfu.main.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnLayout(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    subtitle: @Composable () -> Unit,
    body: @Composable () -> Unit,
    action: @Composable () -> Unit = {}
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title()

        subtitle()

        body()

        action()
    }

}