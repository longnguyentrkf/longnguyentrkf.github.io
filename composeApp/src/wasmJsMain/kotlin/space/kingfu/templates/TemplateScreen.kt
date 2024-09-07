package space.kingfu.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.navigation.Screen

@Composable
fun TemplateScreen(
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxWidth()
    ) {
        Text(text = Screen.Templates.name)
        Spacer(modifier = Modifier.height(height = 7000.dp))
    }

}