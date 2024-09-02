package org.kingfu.portfolio.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.kingfu.portfolio.ui.theme.Typography
import org.kingfu.portfolio.core.fontScale
import org.kingfu.portfolio.home.components.DetailImage
import org.kingfu.portfolio.home.components.Experience
import org.kingfu.portfolio.home.components.Header
import org.kingfu.portfolio.home.components.HireMe
import org.kingfu.portfolio.home.components.ImageDetail
import org.kingfu.portfolio.topBar.MenuTopBar
import org.kingfu.portfolio.ui.theme.Space
import org.kingfu.portfolio.ui.theme.ThemeType
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.clok
import portfolio.composeapp.generated.resources.imaginate
import portfolio.composeapp.generated.resources.longnguyen
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
        BoxWithConstraints {
            val maxWidth = maxWidth
            val fontScale = fontScale(float = this.maxWidth.value)
            val labelFontSize = Typography.titleLarge.fontSize * fontScale
            val labelLineHeight =
                Typography.titleLarge.lineHeight * fontScale

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues = it)
                    .padding(horizontal = Space().medium_16)
                    .verticalScroll(state = scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space = Space().xxLarge_128)


            ) {
                Header(
                    maxWidth = maxWidth,
                    resource = Res.drawable.longnguyen,
                    introduction = "Hello, I am Long Nguyen",
                    whatIDo = "A software engineer and graphic designer based in California",
                    linkedInUrl = "https://www.linkedin.com/in/longnguyentrkf/"
                )

                Column(
                    modifier = Modifier.widthIn(max = 1200.dp),
                    verticalArrangement = Arrangement.spacedBy(space = Space().xxLarge_128)
                ) {


                    Column(verticalArrangement = Arrangement.spacedBy(space = Space().large_32)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Latest Work",
                            fontSize = labelFontSize,
                            lineHeight = labelLineHeight,
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
                            },
                            maxWidth = maxWidth
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
                            },
                            maxWidth = maxWidth
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
                            },
                            maxWidth = maxWidth
                        )
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(space = Space().large_32)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Work Experience",
                            fontSize = labelFontSize,
                            lineHeight = labelLineHeight,
                            textAlign = TextAlign.Center
                        )

                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(space = Space().xLarge_64),
                            verticalArrangement = Arrangement.spacedBy(space = Space().xLarge_64),
                        ) {

                            Experience(
                                title = "Portfolio",
                                subTitle = "Web Developer",
                                body = "August 2024 - Present",
                                maxWidth = maxWidth.value
                            )

                            Experience(
                                title = "Imaginate",
                                subTitle = "Software Engineer, Android",
                                body = "December 2023 - Present",
                                maxWidth = maxWidth.value
                            )

                            Experience(
                                title = "Northrop Grumman",
                                subTitle = "Software Engineer",
                                body = "August 2020 - May 2021",
                                maxWidth = maxWidth.value
                            )
                        }
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(space = Space().large_32)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "What I do",
                            fontSize = labelFontSize,
                            lineHeight = labelLineHeight,
                            textAlign = TextAlign.Center
                        )

                        ImageDetail(
                            list = listOf(
                                "Web Developer",
                                "Brand Design",
                                "Logo Design",
                                "Native Android Engineer",
                                "Mentor"
                            ),
                            buttonText = "View",
                            buttonAction = {
                                val url =
                                    "https://play.google.com/store/apps/dev?id=6685291617439812065&hl=en_US"
                                uriHandler.openUri(uri = url)
                            },
                            resource = Res.drawable.imaginate,
                            maxWidth = maxWidth,
                        )
                    }

                    Column {
                        HireMe(
                            title = "Let's Create Something Amazing Together",
                            subTitle = "Ready to bring your ideas to life through the power of software engineer and " +
                                    "graphic design? I'd love to hear from you! Whether you have a specific project in " +
                                    "mind or simply want to learn more about my services, don't hesitate to reach out.",
                            firstName = firstName,
                            setFirstName = setFirstName,
                            lastName = lastName,
                            setLastName = setLastName,
                            message = message,
                            setMessage = setMessage,
                            toEmail = "longnguyentrkf@gmail.com",
                            maxWidth = maxWidth
                        )
                    }

                    Spacer(modifier = Modifier.height(height = Space().xLarge_64))
                }
            }
        }
    }
}


