package org.kingfu.portfolio.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import kotlinx.browser.window
import org.kingfu.portfolio.core.ScaleMultiplier

@Composable
fun HireMe(
    modifier: Modifier = Modifier,
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit,
) {

    BoxWithConstraints(
        modifier = modifier,
        propagateMinConstraints = true
    ) {
        val multiplier = ScaleMultiplier(float = maxWidth.value)
        val title = "Let's Create Something Amazing Together"
        val titleFontSize = 42.sp * multiplier
        val titleLineHeight = 52.sp * multiplier
        val subTitle =
            "Ready to bring your ideas to life through the power of software engineer and " +
                    "graphic design? I'd love to hear from you! Whether you have a specific project in " +
                    "mind or simply want to learn more about my services, don't hesitate to reach out."
        val subTitleFontSize = 24.sp * multiplier
        val subTitleLineHeight = 34.sp * multiplier
        val toEmail = "longnguyentrkf@gmail.com"
        val focusRequester = remember { FocusRequester() }




        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = if (maxWidth <= 700.dp) 16.dp else 32.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp)
        ) {
            TextBodyLarge(
                text = title,
                fontSize = titleFontSize,
                lineHeight = titleLineHeight
            )

            TextBodyLarge(
                text = subTitle,
                fontSize = subTitleFontSize,
                lineHeight = subTitleLineHeight
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                MyTextField(
                    modifier = Modifier.weight(weight = 0.5f),
                    value = firstName,
                    onValueChange = setFirstName,
                    focusRequester = focusRequester,
                    placeholder = "First Name"
                )

                Spacer(modifier = Modifier.width(width = 16.dp))

                MyTextField(
                    modifier = Modifier.weight(weight = 0.5f),
                    value = lastName,
                    onValueChange = setLastName,
                    focusRequester = focusRequester,
                    placeholder = "Last Name"
                )
            }

            MyTextField(
                value = message,
                onValueChange = setMessage,
                focusRequester = focusRequester,
                placeholder = "Message"
            )

            OutlinedButton(
                onClick = {
                    sendMail(
                        to = toEmail,
                        firstName = firstName,
                        lastName = lastName,
                        message = message
                    )
                }
            ) {
                TextBodyLarge(text = "Send Message")
            }
        }
    }
}

private fun sendMail(
    to: String,
    subject: String = "",
    firstName: String,
    lastName: String,
    message: String
) {
    val emailUri = buildString {
        append("mailto: $to")
        append("?subject=$subject")
        append("&body=$firstName $lastName %0A%0A $message")
    }

    // Open the mail client with the constructed mailto URI
    window.location.href = emailUri
}

