package org.kingfu.portfolio.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import org.kingfu.portfolio.core.fontScale
import org.kingfu.portfolio.core.sendMail
import org.kingfu.portfolio.ui.theme.Space
import org.kingfu.portfolio.ui.theme.Typography

@Composable
fun HireMe(
    modifier: Modifier = Modifier,
    firstName: String,
    setFirstName: (String) -> Unit,
    lastName: String,
    setLastName: (String) -> Unit,
    message: String,
    setMessage: (String) -> Unit,
    maxWidth: Dp,
    title: String? = null,
    titleFontSize: TextUnit = Typography.titleSmall.fontSize * fontScale(float = maxWidth.value),
    titleLineHeight: TextUnit = Typography.titleSmall.lineHeight * fontScale(float = maxWidth.value),
    subTitle: String? = null,
    subTitleFontSize: TextUnit = Typography.bodyMedium.fontSize * fontScale(float = maxWidth.value),
    subTitleLineHeight: TextUnit =Typography.bodyMedium.lineHeight * fontScale(float = maxWidth.value),
    toEmail: String? = null
) {
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = Space().medium_16)
    ) {
        if (title != null) {
            Text(
                text = title,
                fontSize = titleFontSize,
                lineHeight = titleLineHeight
            )
        }

        if (subTitle != null) {
            Text(
                text = subTitle,
                fontSize = subTitleFontSize,
                lineHeight = subTitleLineHeight
            )
        }

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

            Spacer(modifier = Modifier.width(width = Space().medium_16))

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
            placeholder = "Message",
        )

        if (toEmail != null) {
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
                Text(
                    text = "Send Message",
                    style = Typography.bodySmall
                )
            }
        }
    }
}

