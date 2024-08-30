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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.kingfu.portfolio.home.component.DetailImage
import org.kingfu.portfolio.home.component.Experience
import org.kingfu.portfolio.home.component.Header
import org.kingfu.portfolio.home.component.HireMe
import org.kingfu.portfolio.home.component.ImageDetail
import org.kingfu.portfolio.home.component.WhatIDo
import org.kingfu.portfolio.topBar.MenuTopBar
import org.kingfu.portfolio.ui.theme.ThemeType
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.clok
import portfolio.composeapp.generated.resources.imaginate
import portfolio.composeapp.generated.resources.weatherai


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    theme: ThemeType,
    setTheme: (ThemeType) -> Unit,
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit,
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val fontSize = 42.sp
    val lineHeight = 52.sp
    val uriHandler = LocalUriHandler.current
    val focusManager = LocalFocusManager.current



    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }




    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            MenuTopBar(
                title = "Long Nguyen",
                scrollBehavior = scrollBehavior,
                theme = theme,
                setTheme = setTheme,
                scrollState = scrollState
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

            Header()

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

                ImageDetail(
                    title = "Imaginate",
                    subTitle = "Android Application",
                    body = "Imaginate brings creative innovation to life with AI-generated masterpieces that " +
                            "you can download or set as wallpapers. Enjoy intuitive search, and customize your experience with themes.",
                    buttonText = "Download",
                    resource = Res.drawable.imaginate,
                    buttonAction = {
                        val url =
                            "https://play.google.com/store/apps/details?id=com.kingfu.aigallery&hl=en_US"
                        uriHandler.openUri(uri = url)
                    }
                )

                DetailImage(
                    title = "WeatherAI",
                    subTitle = "Android Application",
                    body = "WeatherAI is a sleek weather app offering accurate 7-day forecasts and hourly updates. " +
                            "AI-powered weather answers from ChatGPT, and unique wallpapers created by AI.",
                    buttonText = "Download",
                    resource = Res.drawable.weatherai,
                    buttonAction = {
                        val url =
                            "https://play.google.com/store/apps/details?id=com.kingfu.weatherai&hl=en_US"
                        uriHandler.openUri(uri = url)
                    }
                )

                ImageDetail(
                    title = "Clok",
                    subTitle = "Android Application",
                    body = "Clok is a versatile time management app that combines a Stopwatch and Timer with " +
                            "automatic data saving. Its user-friendly " +
                            "design adapts to your device’s theme, tracks laps, and enhances productivity with smooth performance.",
                    buttonText = "Download",
                    resource = Res.drawable.clok,
                    buttonAction = {
                        val url =
                            "https://play.google.com/store/apps/details?id=com.kingfu.clok&hl=en_US"
                        uriHandler.openUri(uri = url)
                    }
                )

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

                    Experience(
                        title = "Portfolio",
                        subTitle = "Web Developer",
                        body = "August 2024 - Present"
                    )

                    Experience(
                        title = "Imaginate",
                        subTitle = "Software Engineer, Android",
                        body = "December 2023 - Present"
                    )

                    Experience(
                        title = "Northrop Grumman",
                        subTitle = "Software Engineer",
                        body = "August 2020 - May 2021"
                    )
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

                HireMe(
                    firstName = firstName,
                    setFirstName = setFirstName,
                    lastName = lastName,
                    setLastName = setLastName,
                    message = message,
                    setMessage = setMessage,
                )

                Spacer(modifier = Modifier.height(height = 68.dp))


            }
        }
    }
}

