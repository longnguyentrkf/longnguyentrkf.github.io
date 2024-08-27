package org.kingfu.portfolio.core


fun String.formatEnumName() = this
    .replace(oldChar = '_', newChar = ' ')
    .lowercase()
    .replaceFirstChar { it.uppercase() }

