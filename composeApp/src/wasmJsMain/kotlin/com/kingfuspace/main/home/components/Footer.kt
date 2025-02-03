//package com.kingfuspace.main.home.components
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalUriHandler
//import androidx.compose.ui.unit.dp
//import com.kingfuspace.main.core.BODY
//import com.kingfuspace.main.core.MAIL_TO
//import com.kingfuspace.main.core.SUBJECT
//import com.kingfuspace.main.core.customUrlEncode
//import com.kingfuspace.main.ui.components.MyTextField
//import com.kingfuspace.main.ui.theme.Typography
//import kotlinx.browser.window
//
//
//@Composable
//fun Footer(
//    modifier: Modifier = Modifier,
//    firstName: String,
//    setFirstName: (String) -> Unit,
//    lastName: String,
//    setLastName: (String) -> Unit,
//    message: String,
//    setMessage: (String) -> Unit,
//    title: String,
//    body: String,
//    toEmail: String
//) {
//    val uriHandler = LocalUriHandler.current
//
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(space = 24.dp)
//    ) {
//        Text(
//            text = title,
//            style = Typography.bodyLarge
//        )
//
//        Text(
//            text = body,
//            style = Typography.bodySmall
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//
//            MyTextField(
//                modifier = Modifier.weight(weight = 0.5f),
//                value = firstName,
//                onValueChange = { setFirstName(it) },
//                label = "First Name"
//            )
//
//            Spacer(modifier = Modifier.width(width = 16.dp))
//
//            MyTextField(
//                modifier = Modifier.weight(weight = 0.5f),
//                value = lastName,
//                onValueChange = { setLastName(it) },
//                label = "Last Name"
//            )
//        }
//
//        MyTextField(
//            value = message,
//            onValueChange = { setMessage(it) },
//            label = "Message",
//        )
//
//        OutlinedButton(
//            onClick = {
//                val subject = "Subject"
//                val mailBody = "$firstName $lastName\n\n$message"
//                val emailUri = buildString {
//                    append(MAIL_TO+toEmail)
//                    append(SUBJECT+subject.customUrlEncode())
//                    append(BODY + mailBody.customUrlEncode())
//                }
//
//                uriHandler.openUri(uri = emailUri)
//            }
//        ) {
//            Text(
//                text = "Send Message"
//            )
//        }
//    }
//}
//
