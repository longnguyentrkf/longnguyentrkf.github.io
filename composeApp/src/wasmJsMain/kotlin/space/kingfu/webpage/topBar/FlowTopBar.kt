package space.kingfu.webpage.topBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ExperimentalMaterial3Api
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
import space.kingfu.webpage.flow.ui.FlowText
import space.kingfu.webpage.flow.viewModel.TextData
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigationContent: @Composable () -> Unit = {},
    actions: @Composable (RowScope.() -> Unit) = {},
    title: TextData,
    setTopBarTitle: (TextData) -> Unit,
    topBarTitle: TextData
) {

    Box(
        modifier = Modifier.fillMaxWidth().offset(x = (-8).dp),
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
//                    FlowTitle(
//                        modifier = Modifier.width(width = 320.dp),
//                        placeholder = "title",
//                        title = title,
//                        textStyle = Typography.bodySmall,
//                        fontWeight = FontWeight.Normal,
//                        textAlign = TextAlign.Center,
//                        contentAlignment = Alignment.Center,
//                        isSingleLine = true,
//                        maxChar = 50,
//                        onValueChange = { setTopBarTitle(TextData(isEdit = true, text = it)) },
//                        done = {
//                            setTopBarTitle(
//                                TextData(
//                                    isEdit = false,
//                                    text = topBarTitle.text
//                                )
//                            )
//                        },
//                        onClick = {
//                            setTopBarTitle(
//                                TextData(
//                                    isEdit = true,
//                                    text = topBarTitle.text
//                                )
//                            )
//                        },
//                    )
                    FlowText(
                        modifier = Modifier.width(width = 320.dp),
                        placeholder = "title",
                        text = title.text,
                        style = Typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        contentAlignment = Alignment.Center,
                        isSingleLine = true,
                        maxChar = 50,
                        onValueChange = { setTopBarTitle(TextData(isEdit = true, text = it)) },
                        done = {
                            setTopBarTitle(
                                TextData(
                                    isEdit = false,
                                    text = topBarTitle.text
                                )
                            )
                        },
                        clickable = {
                            setTopBarTitle(
                                TextData(
                                    isEdit = true,
                                    text = topBarTitle.text
                                )
                            )
                        },
                        isEdit = title.isEdit
                    )
                }
            },
            actions = actions
        )
    }
}



