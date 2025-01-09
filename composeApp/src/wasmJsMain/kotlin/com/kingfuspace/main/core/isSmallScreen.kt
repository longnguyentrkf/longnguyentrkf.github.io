package com.kingfuspace.main.core

import com.kingfuspace.main.core.Variables.windowInnerWidth


fun isSmallScreen(addedWidth: Int = 0): Boolean = windowInnerWidth < SMALL_WINDOW + addedWidth