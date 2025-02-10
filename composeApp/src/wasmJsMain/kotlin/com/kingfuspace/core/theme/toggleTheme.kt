package com.kingfuspace.core.theme


fun ThemeType.toggle() = if (this == ThemeType.DARK) ThemeType.LIGHT else ThemeType.DARK
