package org.kingfu.portfolio.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.topBar.BackTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    goBack: () -> Unit
) {
    Scaffold(
        topBar = {
            BackTopBar(
                title = Screen.Settings.name,
                goBack = goBack
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TextBodyLarge(text = "Settings")
        }
    }
}