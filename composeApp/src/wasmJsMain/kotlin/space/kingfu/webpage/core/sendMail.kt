package space.kingfu.webpage.core

import kotlinx.browser.window

fun sendMail(
    to: String,
    subject: String = "",
    firstName: String,
    lastName: String,
    message: String
) {
    try {
        val emailUri = buildString {
            append("mailto: $to")
            append("?subject=$subject")
            append("&body=$firstName $lastName %0A%0A $message")
        }

        // Open the mail client with the constructed mailto URI
        window.location.href = emailUri
    } catch (e: Exception) {
        println("Send Mail error: $e")
    }
}