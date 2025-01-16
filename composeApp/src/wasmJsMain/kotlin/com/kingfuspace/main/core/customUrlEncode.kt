package com.kingfuspace.main.core

// Custom URL encoding function for Compose Multiplatform (WASM)
fun String.customUrlEncode(): String {
    return this
        .replace(" ", "%20")
        .replace("\n", "%0A")
        .replace("\r", "%0D")
        .replace("?", "%3F")
        .replace("&", "%26")
        .replace("=", "%3D")
    // Add more replacements as needed for special characters
}