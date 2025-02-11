package com.kingfuspace.main.home

import KingfuspaceCanvas
import WeatherAI
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.Variables.windowInnerWidth
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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 64.dp)
    ) {

        Header(paddingValues = paddingValues)

        Column(
            modifier = Modifier
                .widthIn(max = 1200.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Latest Work",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall
            )

            Portfolio()

            Imaginate()

            WeatherAI()

            Clok()
        }

        Footer(
            modifier = Modifier
                .widthIn(max = 1200.dp)
                .padding(horizontal = 16.dp),
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




