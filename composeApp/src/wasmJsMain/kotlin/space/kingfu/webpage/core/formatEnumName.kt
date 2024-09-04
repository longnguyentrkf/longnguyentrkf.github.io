package space.kingfu.webpage.core


fun String.formatEnumName() = this
    .replace(oldChar = '_', newChar = ' ')
    .lowercase()
    .replaceFirstChar { it.uppercase() }

