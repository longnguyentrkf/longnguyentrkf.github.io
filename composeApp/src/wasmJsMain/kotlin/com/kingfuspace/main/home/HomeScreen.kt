package com.kingfuspace.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.core.isSmallScreen
import com.kingfuspace.main.home.components.DetailImage
import com.kingfuspace.main.home.components.Footer
import com.kingfuspace.main.home.components.Header
import com.kingfuspace.main.home.components.ImageDetail
import com.kingfuspace.main.ui.theme.Typography
import kingfuspace.composeapp.generated.resources.Res
import kingfuspace.composeapp.generated.resources.clok
import kingfuspace.composeapp.generated.resources.imaginate
import kingfuspace.composeapp.generated.resources.longnguyen
import kingfuspace.composeapp.generated.resources.weatherai


@Composable
fun HomeScreen(
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit,
    paddingValues: PaddingValues,
) {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    BoxWithConstraints {
        val maxWidth = maxWidth

        val fontScale = com.kingfuspace.main.core.fontScale(float = this.maxWidth.value)
        val labelFontSize = Typography.titleLarge.fontSize * fontScale
        val labelLineHeight = Typography.titleLarge.lineHeight * fontScale

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 128.dp)
        ) {

            Header(paddingValues = paddingValues)

            Column(
                modifier = Modifier.widthIn(max = 1200.dp),
                verticalArrangement = Arrangement.spacedBy(space = 128.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(space = 32.dp)) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Latest Work",
                        fontSize = labelFontSize,
                        lineHeight = labelLineHeight,
                        textAlign = TextAlign.Center
                    )

                    ImageDetail(
                        title = "Portfolio",
                        subTitle = "Web Application",
                        body = "A sleek designed webpage showcasing achievements, experiences, and services.",
                        resource = Res.drawable.longnguyen,
                        imageContentScale = ContentScale.Fit,
                        isSmallScreen = isSmallScreen()
                    )

                    DetailImage(
                        title = "Imaginate",
                        subTitle = "Android Application",
                        body = "Imaginate brings creative innovation to life with AI-generated masterpieces that " +
                                "you can download or set as wallpapers. Enjoy intuitive search, and customize your experience with themes.",
                        resource = Res.drawable.imaginate,
                        maxWidth = maxWidth,
                        buttonList = {
                            OutlinedButton(
                                onClick = {
                                    val url =
                                        "https://play.google.com/store/apps/details?id=com.kingfu.aigallery&hl=en_US"
                                    uriHandler.openUri(uri = url)
                                }
                            ) {
                                Text(
                                    text = "Download",
                                    style = Typography.bodySmall
                                )
                            }
                        },
                        isSmallScreen = isSmallScreen()
                    )

                    ImageDetail(
                        title = "WeatherAI",
                        subTitle = "Android Application",
                        body = "WeatherAI is a sleek weather app offering accurate 7-day forecasts and hourly updates. " +
                                "AI-powered weather answers from ChatGPT, and unique wallpapers created by AI.",
                        resource = Res.drawable.weatherai,
                        isSmallScreen = isSmallScreen()
                    )

                    DetailImage(
                        title = "Clok",
                        subTitle = "Android Application",
                        body = "Clok is a versatile time management app that combines a Stopwatch and Timer with " +
                                "automatic data saving. Its user-friendly " +
                                "design adapts to your device’s theme, tracks laps, and enhances productivity with smooth performance.",
                        resource = Res.drawable.clok,
                        maxWidth = maxWidth,
                        buttonList = {
                            OutlinedButton(
                                onClick = {
                                    val url =
                                        "https://play.google.com/store/apps/details?id=com.kingfu.clok&hl=en_US"
                                    uriHandler.openUri(uri = url)
                                }
                            ) {
                                Text(
                                    text = "Download",
                                    style = Typography.bodySmall
                                )
                            }
                        },
                        isSmallScreen = isSmallScreen()
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(space = 32.dp)) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "What I do",
                        fontSize = labelFontSize,
                        lineHeight = labelLineHeight,
                        textAlign = TextAlign.Center
                    )

                    ImageDetail(
//                        resource = Res.drawable.kingfuspace_logo_no_background,
                        resource = Res.drawable.clok,
                        list = listOf(
                            "Web Developer",
                            "Brand Design",
                            "Logo Design",
                            "Native Android Engineer",
                            "Mentor"
                        ),
                        imageContentScale = ContentScale.Fit,
                        isSmallScreen = isSmallScreen()
                    )
                }

                Column {
                    Footer(
                        title = "Let's Create Something Amazing Together",
                        body = "Ready to bring your ideas to life through the power of software engineer and " +
                                "graphic design? I'd love to hear from you! Whether you have a specific project in " +
                                "mind or simply want to learn more about my services, don't hesitate to reach out.",
                        firstName = firstName,
                        setFirstName = setFirstName,
                        lastName = lastName,
                        setLastName = setLastName,
                        message = message,
                        setMessage = setMessage,
                        toEmail = "longnguyentrkf@gmail.com"
                    )
                }

                Spacer(modifier = Modifier.height(height = 64.dp))
            }
        }
    }
}




