package org.kingfu.portfolio.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.topBar.MenuTopBar
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.longnguyen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    toggleDrawer: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            MenuTopBar(
                title = Screen.Home.name,
                toggleDrawer = toggleDrawer
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .height(height = 500.dp)
                        .weight(weight = 0.5f),
                    painter = painterResource(Res.drawable.longnguyen),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(weight = 0.5f),
                    text = "Hi, my name is Long Nguyen. I am a Software Engineer based in Anaheim, California.",
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    lineHeight = 48.sp
                )
            }

            Spacer(modifier = Modifier.height(height = 400.dp))
        }
    }
}