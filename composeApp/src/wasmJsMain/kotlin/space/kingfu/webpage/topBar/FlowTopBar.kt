package space.kingfu.webpage.topBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.components.FlowBody
import space.kingfu.webpage.flow.components.FlowTitleHeader
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigationContent: @Composable () -> Unit = {},
    actionContent: @Composable (RowScope.() -> Unit) = {},
    title: TextData,
    setTopBarTitle: (TextData) -> Unit
) {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            scrollBehavior = scrollBehavior,
            modifier = modifier.widthIn(max = 1200.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                scrolledContainerColor = Transparent,
                containerColor = Transparent
            ),
            navigationIcon = navigationContent,
            title = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    FlowTitleHeader(
                        modifier = Modifier.width(width = 320.dp),
                        setTitle = setTopBarTitle,
                        placeholder = "title",
                        title = title,
                        style = Typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        contentAlignment = Alignment.Center,
                        isSingleLine = true,
                        maxChar = 50
                    )
                }
            },
            actions = actionContent
        )
    }
}



