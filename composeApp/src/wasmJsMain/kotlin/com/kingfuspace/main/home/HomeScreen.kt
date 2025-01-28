package com.kingfuspace.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.core.isSmallScreen
import com.kingfuspace.main.home.components.Body1
import com.kingfuspace.main.home.components.Body2
import com.kingfuspace.main.home.components.Body3
import com.kingfuspace.main.home.components.Header


@Composable
fun HomeScreen(
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit
) {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) focusManager.clearFocus()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Header()

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = if (isSmallScreen()) 64.dp else 0.dp),
            text = "Latest Work",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )

        Body1(modifier = Modifier.widthIn(max = 1200.dp))

        Body2(modifier = Modifier.widthIn(max = 1200.dp))

        Body3(modifier = Modifier.widthIn(max = 1200.dp))

        Spacer(modifier = Modifier.height(height = 640.dp))

    }

//                Column(verticalArrangement = Arrangement.spacedBy(space = 32.dp)) {
//                    Text(
//                        modifier = Modifier.fillMaxWidth(),
//                        text = "What I do",
//                        fontSize = labelFontSize,
//                        lineHeight = labelLineHeight,
//                        textAlign = TextAlign.Center
//                    )
//
//                    ImageDetail(
////                        resource = Res.drawable.kingfuspace_logo_no_background,
//                        resource = Res.drawable.clok,
//                        list = listOf(
//                            "Web Developer",
//                            "Brand Design",
//                            "Logo Design",
//                            "Native Android Engineer",
//                            "Mentor"
//                        ),
//                        imageContentScale = ContentScale.Fit,
//                        isSmallScreen = isSmallScreen()
//                    )
//                }
//
//                Column {
//                    Footer(
//                        title = "Let's Create Something Amazing Together",
//                        body = "Ready to bring your ideas to life through the power of software engineer and " +
//                                "graphic design? I'd love to hear from you! Whether you have a specific project in " +
//                                "mind or simply want to learn more about my services, don't hesitate to reach out.",
//                        firstName = firstName,
//                        setFirstName = setFirstName,
//                        lastName = lastName,
//                        setLastName = setLastName,
//                        message = message,
//                        setMessage = setMessage,
//                        toEmail = "longnguyentrkf@gmail.com"
//                    )
//                }
//
//            }
//        }
//    }
}




