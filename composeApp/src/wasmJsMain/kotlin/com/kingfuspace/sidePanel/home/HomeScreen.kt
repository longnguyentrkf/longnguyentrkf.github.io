package com.kingfuspace.sidePanel.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.ui.theme.Typography
import com.kingfuspace.sidePanel.navigation.SidePanelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goToBanners: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = SidePanelDestination.HOME.label,
                        style = Typography.bodySmall
                    )
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(all = 8.dp),
                        imageVector = Icons.Rounded.Home,
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        Column(modifier = modifier.padding(paddingValues = it)) {
            Text(
                modifier = Modifier
                    .clickable { goToBanners() }
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                text = SidePanelDestination.BANNERS.label,
                style = Typography.bodySmall
            )
        }
    }
}