package com.kingfuspace.main.home.components

import KingfuspaceCanvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.unit.dp
import com.kingfuspace.core.BODY
import com.kingfuspace.core.MAIL_TO
import com.kingfuspace.core.SUBJECT
import com.kingfuspace.main.ui.components.MyTextField
import com.kingfuspace.main.ui.theme.typography


@Composable
fun Footer(
    modifier: Modifier = Modifier,
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit,
) {
    val uriHandler = LocalUriHandler.current
    val title = "Let's Create Something Amazing Together"
    val body = "Ready to bring your ideas to life through the power of software engineer and " +
            "graphic design? I'd love to hear from you! Whether you have a specific project in " +
            "mind or simply want to learn more about my services, don't hesitate to reach out."
    val toEmail = "longnguyentrkf@gmail.com"


    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 24.dp)
    ) {

        Text(
            text = title,
            style = typography.headlineLarge
        )

        Text(
            text = body,
            style = typography.bodyLarge
        )

        Row {
            MyTextField(
                modifier = Modifier.weight(weight = 0.5f),
                value = firstName,
                onValueChange = { setFirstName(it) },
                label = "First name",
                isSingleLine = true
            )

            Spacer(modifier = Modifier.width(width = 24.dp))

            MyTextField(
                modifier = Modifier.weight(weight = 0.5f),
                value = lastName,
                onValueChange = { setLastName(it) },
                label = "Last name",
                isSingleLine = true
            )
        }

        MyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = message,
            onValueChange = { setMessage(it) },
            label = "Message",
            isSingleLine = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                onClick = {
                    val subject = "Subject"
                    val mailBody = "$firstName $lastName%0A%0A$message"
                    val emailUri = buildString {
                        append(value = MAIL_TO + toEmail)
                        append(value = SUBJECT + subject)
                        append(value = BODY + mailBody)
                    }

                    uriHandler.openUri(uri = emailUri)
                }
            ) {
                Text(
                    text = "Send message",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

