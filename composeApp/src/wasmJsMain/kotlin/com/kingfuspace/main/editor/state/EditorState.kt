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
    open val layoutType: LayoutType?,
    open val components: MutableList<ComponentType>?,
    open val height: Dp = DEFAULT_HEIGHT,
) {
    private companion object {
        val DEFAULT_HEIGHT = 500.dp
    }

    data class Banner1(
        override val id: Int,
        override val name: String,
        override val layoutType: LayoutType? = LayoutType.LAYOUT_1,
        override val height: Dp = DEFAULT_HEIGHT,
        val images: MutableList<ImageData> = mutableStateListOf(ImageData()),
        val texts: MutableList<TextData> = mutableStateListOf(TextData()),
//        val buttons: MutableList<ButtonData> = mutableStateListOf(),
        val isReverse: Boolean = false,
    ) : Banner(id = id, name = name, layoutType = layoutType, components = null)

    data class Banner2(
        override val id: Int,
        override val name: String,
        override val layoutType: LayoutType? = LayoutType.LAYOUT_2,
        override val height: Dp = DEFAULT_HEIGHT,
        val textsBody: MutableList<TextData> = mutableStateListOf()
    ) : Banner(id = id, name = name, layoutType = layoutType, components = null)
}

enum class LayoutType {
    LAYOUT_1,
    LAYOUT_2
}

enum class ComponentType {
    IMAGE,
    TEXT
}

data class ImageData(
    val name: String = "Image",
    val url: String = "",
    val scale: Float = 1f,
)

data class TextData(
    val name: String = "Text",
    val text: String = "",
    val style: TextStyle = Typography.labelLarge,
    val isClickable: Boolean = true,
    val weight: Float = 1f
)

sealed class Component(
    open val id: Long,
    open val name: String,
    open val type: ComponentType? = null
){

    data class ImageComponent(
        override val id: Long,
        override val name: String,
        override val type: ComponentType = ComponentType.IMAGE,
        val url: String = "",
        val scale: Float = 1f,
    ): Component(id = id, name = "Image")


    data class TextComponent(
        override val id: Long,
        override val name: String,
        override val type: ComponentType = ComponentType.TEXT,
        val text: String = "",
        val style: TextStyle = Typography.labelLarge,
        val isClickable: Boolean = true,
        val weight: Float = 1f
    ): Component(id = id, name  = "Text")

}



//data class ButtonData(
//    val text: String = "",
//    val url: String = "",
//)







