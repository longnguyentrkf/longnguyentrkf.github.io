package org.kingfu.portfolio.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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
import org.kingfu.portfolio.home.component.Clok
import org.kingfu.portfolio.home.component.Imaginate
import org.kingfu.portfolio.home.component.ImaginateExperience
import org.kingfu.portfolio.home.component.Introduction
import org.kingfu.portfolio.home.component.NorthropGrummanExperience
import org.kingfu.portfolio.home.component.WeatherAI
import org.kingfu.portfolio.home.component.WebDeveloperExperience
import org.kingfu.portfolio.home.component.WhatIDo
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.topBar.MenuTopBar


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    toggleDrawer: () -> Unit
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val fontSize = 42.sp
    val lineHeight = 52.sp

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
                .fillMaxWidth()
                .padding(paddingValues = it)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Introduction()

            Spacer(modifier = Modifier.height(height = 128.dp))

            Column(
                modifier = Modifier.widthIn(max = 1200.dp),
                verticalArrangement = Arrangement.spacedBy(space = 42.dp)
            ) {
                TextBodyLarge(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Latest Work",
                    fontSize = fontSize,
                    lineHeight = lineHeight,
                    textAlign = TextAlign.Center
                )

                Imaginate()

                WeatherAI()

                Clok()

                Spacer(modifier = Modifier.height(height = 68.dp))

                TextBodyLarge(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Work Experience",
                    fontSize = fontSize,
                    lineHeight = lineHeight,
                    textAlign = TextAlign.Center
                )

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(space = 42.dp),
                    verticalArrangement = Arrangement.spacedBy(space = 42.dp)
                ) {

                    WebDeveloperExperience()

                    ImaginateExperience()

                    NorthropGrummanExperience()
                }


                Spacer(modifier = Modifier.height(height = 68.dp))

                TextBodyLarge(
                    modifier = Modifier.fillMaxWidth(),
                    text = "What I do",
                    fontSize = fontSize,
                    lineHeight = lineHeight,
                    textAlign = TextAlign.Center
                )

                WhatIDo()

                Spacer(modifier = Modifier.height(height = 68.dp))

            }
        }
    }
}

