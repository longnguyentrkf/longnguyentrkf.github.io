package space.kingfu.main.core


fun String.formatEnumName() = this
    .replace(oldChar = '_', newChar = ' ')
    .lowercase()
    .replaceFirstChar { it.uppercase() }

fun String.formatEnumNameAllLowerCase() = this
    .replace(oldChar = '_', newChar = ' ')
    .lowercase()
