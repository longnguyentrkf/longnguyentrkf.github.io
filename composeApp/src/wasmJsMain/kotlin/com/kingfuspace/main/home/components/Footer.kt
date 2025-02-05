package com.kingfuspace.main.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.core.BODY
import com.kingfuspace.main.core.MAIL_TO
import com.kingfuspace.main.core.SUBJECT
import com.kingfuspace.main.ui.theme.Shape


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
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 24.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge
        )

        Row(modifier = Modifier.fillMaxWidth()) {

            OutlinedTextField(
                modifier = Modifier.weight(weight = 0.5f),
                shape = CircleShape,

                value = firstName,
                onValueChange = { setFirstName(it) },
                label = { Text(text = "First name") },
                singleLine = true
            )

            Spacer(modifier = Modifier.width(width = 16.dp))

            OutlinedTextField(
                modifier = Modifier.weight(weight = 0.5f),
                shape = CircleShape,
                value = lastName,
                onValueChange = { setLastName(it) },
                label = { Text(text = "Last name") },
                singleLine = true
            )
        }

        OutlinedTextField(

            modifier = Modifier.fillMaxWidth(),
            shape = CircleShape,
            value = message,
            onValueChange = { setMessage(it) },
            label = { Text(text = "Message") },
            singleLine = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                shape = CircleShape,
                onClick = {
                    val subject = "Subject"
                    val mailBody = "$firstName $lastName%0A%0A$message"
                    val emailUri = buildString {
                        append(MAIL_TO + toEmail)
                        append(SUBJECT + subject)
                        append(BODY + mailBody)
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

