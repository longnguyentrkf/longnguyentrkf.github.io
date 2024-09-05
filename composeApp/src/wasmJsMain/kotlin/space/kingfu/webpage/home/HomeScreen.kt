package space.kingfu.webpage.home

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.clok
import kingfu.composeapp.generated.resources.imaginate
import kingfu.composeapp.generated.resources.kingfu_no_background
import kingfu.composeapp.generated.resources.kingfu_rectangle
import kingfu.composeapp.generated.resources.longnguyen
import kingfu.composeapp.generated.resources.weatherai
import kotlinx.coroutines.launch
import space.kingfu.webpage.home.components.DetailImage
import space.kingfu.webpage.home.components.Header
import space.kingfu.webpage.home.components.HireMe
import space.kingfu.webpage.home.components.ImageDetail
import space.kingfu.webpage.navigation.Screen
import space.kingfu.webpage.topBar.MenuTopBar
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.ThemeType
import space.kingfu.webpage.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
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
    toggleDrawer: () -> Unit,
    goToShop: () -> Unit,
    scrollState: ScrollState,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val uriHandler = LocalUriHandler.current
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }


    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            MenuTopBar(
                title = "KingFu",
                titleOnClick = { scope.launch { scrollState.animateScrollTo(value = 0) } },
                scrollBehavior = scrollBehavior,
                theme = theme,
                setTheme = setTheme,
                actionText = Screen.Shop.name,
                actionOnClick = goToShop,
                navigationIconOnClick = toggleDrawer
            )
        }
    ) {
        BoxWithConstraints {
            val maxWidth = maxWidth
            val fontScale = space.kingfu.webpage.core.fontScale(float = this.maxWidth.value)
            val labelFontSize = Typography.titleLarge.fontSize * fontScale
            val labelLineHeight = Typography.titleLarge.lineHeight * fontScale

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
                    resource = Res.drawable.kingfu_no_background,
                    title = "Introducing KingFu",
                    subTitle = "Create your platform with cutting-edge technologies",
                    imageScale = 0.5f
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
                            title = "Portfolio",
                            subTitle = "Web Application",
                            body = "A sleek designed webpage showcasing achievements, experiences, and services.",
                            buttonText = "View",
                            resource = Res.drawable.longnguyen,
                            buttonAction = {
                                val url = "https://kingfu.space/longnguyen/"
                                uriHandler.openUri(uri = url)
                            },
                            maxWidth = maxWidth,
                            imageContentScale = ContentScale.Fit
                        )

                        DetailImage(
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

                        ImageDetail(
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

                        DetailImage(
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
                            resource = Res.drawable.kingfu_rectangle,
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


