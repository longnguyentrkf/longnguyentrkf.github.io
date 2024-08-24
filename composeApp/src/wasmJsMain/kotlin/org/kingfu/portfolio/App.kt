package org.kingfu.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.longnguyen

@Composable
fun App() {
    MaterialTheme {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.height(height = 400.dp),
                painter = painterResource(Res.drawable.longnguyen),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(height = 18.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "Hi, my name is Long Nguyen. I am a Software Engineer.",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(height = 200.dp))
        }

    }
}