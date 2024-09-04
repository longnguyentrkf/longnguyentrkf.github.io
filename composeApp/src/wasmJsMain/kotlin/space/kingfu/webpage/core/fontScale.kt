package space.kingfu.webpage.core

import kotlin.math.log10

fun fontScale(float: Float): Float{
    return log10((float + 10).coerceIn(1f, 1000f)) * 0.25f // Adjust 0.2f as needed
}