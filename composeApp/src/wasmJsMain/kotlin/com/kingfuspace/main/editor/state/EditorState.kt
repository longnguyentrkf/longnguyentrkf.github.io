package com.kingfuspace.main.editor.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kingfuspace.main.ui.theme.Typography


data class EditorState(
    val banners: MutableList<Banner> = mutableStateListOf(),
    val bannerIndex: Int? = null,
    val bannerCounter: Int = 0,
)

sealed class Banner(
    open val id: Int,
    open val name: String,
    open val bannerType: BannerType?,
    open val height: Dp = DEFAULT_HEIGHT,
) {
    private companion object {
        val DEFAULT_HEIGHT = 500.dp
    }

    data class Banner1(
        override val id: Int,
        override val name: String,
        override val bannerType: BannerType? = BannerType.TYPE_1,
        override val height: Dp = DEFAULT_HEIGHT,
        val images: MutableList<ImageData> = mutableStateListOf(),
        val texts: MutableList<TextData> = mutableStateListOf(),
        val buttons: MutableList<ButtonData> = mutableStateListOf(),
        val isReverse: Boolean = false,
    ) : Banner(id, name, bannerType)

    data class Banner2(
        override val id: Int,
        override val name: String,
        override val bannerType: BannerType? = BannerType.TYPE_2,
        override val height: Dp = DEFAULT_HEIGHT,
        val textsBody: MutableList<TextData> = mutableStateListOf()
    ) : Banner(id, name, bannerType)
}

enum class BannerType {
    TYPE_1,
    TYPE_2
}

data class ImageData(
    val name: String = "Image",
    val url: String = "",
    val scale: Float = 1f,
)

data class TextData(
    val name: String = "Text",
    val text: String = "",
    val style: TextStyle = Typography.bodySmall,
)

data class ButtonData(
    val text: String = "",
    val url: String = "",
)







