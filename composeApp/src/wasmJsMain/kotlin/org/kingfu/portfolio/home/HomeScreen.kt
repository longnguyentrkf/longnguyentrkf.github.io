package org.kingfu.portfolio.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.kingfu.portfolio.home.component.Imaginate
import org.kingfu.portfolio.home.component.Introduction
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.topBar.MenuTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    toggleDrawer: () -> Unit
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            MenuTopBar(
                title = Screen.Home.name,
                toggleDrawer = toggleDrawer,
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Introduction()

            Spacer(modifier = Modifier.height(height = 128.dp))

            val fontSize = 42.sp
            val lineHeight = 52.sp

            TextBodyLarge(
                modifier = Modifier.fillMaxWidth(),
                text = "Latest Work",
                fontSize = fontSize,
                lineHeight = lineHeight,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(height = 32.dp))

            Imaginate()

            Spacer(modifier = Modifier.height(height = 500.dp))
        }
    }
}

