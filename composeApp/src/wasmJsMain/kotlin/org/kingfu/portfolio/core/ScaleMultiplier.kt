package org.kingfu.portfolio.core

import kotlin.math.log10

fun ScaleMultiplier(float: Float): Float{
    return log10((float + 10).coerceIn(1f, 1000f)) * 0.25f // Adjust 0.2f as needed
}