package com.kingfuspace.main.core

fun String?.isValidUrl(): Boolean {
    val urlRegex = "^(http|https)://[a-zA-Z0-9-._~:/?#\\[\\]@!$&'()*+,;=%]+\$".toRegex()
    return this?.matches(urlRegex) ?: false
}
