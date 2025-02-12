package com.kingfuspace.main.home

import WeatherAI
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.Variables.windowInnerHeight
import com.kingfuspace.main.home.components.Clok
import com.kingfuspace.main.home.components.Footer
import com.kingfuspace.main.home.components.Header
import com.kingfuspace.main.home.components.Imaginate
import com.kingfuspace.main.home.components.Portfolio


@Composable
fun HomeScreen(
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit,
    paddingValues: PaddingValues,
    scrollState: ScrollState
) {
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space = 64.dp)
            ) {

                Header(
                    modifier = Modifier
                        .padding(all = 24.dp)
                        .height(
                            height = (windowInnerHeight.dp - paddingValues.calculateTopPadding())
                                .coerceAtLeast(minimumValue = 0.dp)
                        )
                )

                Column(modifier = Modifier.widthIn(max = 1200.dp)) {
                    Text(
                        modifier = Modifier.padding(all = 24.dp).fillMaxWidth(),
                        text = "Latest Work",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displaySmall
                    )

                    Portfolio(modifier = Modifier.padding(all = 24.dp))

                    Imaginate(modifier = Modifier.padding(all = 24.dp))

                    WeatherAI(modifier = Modifier.padding(all = 24.dp))

                    Clok(modifier = Modifier.padding(all = 24.dp))
                }

                Footer(
                    modifier = Modifier.padding(all = 24.dp).widthIn(max = 1200.dp),
                    firstName = firstName,
                    setFirstName = setFirstName,
                    lastName = lastName,
                    setLastName = setLastName,
                    message = message,
                    setMessage = setMessage,
                )

                Spacer(modifier = Modifier.height(height = 100.dp))


            }
        }

        VerticalScrollbar(
            modifier = Modifier
                .alpha(alpha = 0.5f)
                .align(alignment = Alignment.CenterEnd)
                .padding(end = 4.dp)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(scrollState = scrollState),
            style = defaultScrollbarStyle().copy(
                thickness = 8.dp,
                unhoverColor = colorScheme.outlineVariant,
                hoverColor = colorScheme.outlineVariant,
                minimalHeight = 24.dp,
                shape = CircleShape
            )
        )
    }
}




