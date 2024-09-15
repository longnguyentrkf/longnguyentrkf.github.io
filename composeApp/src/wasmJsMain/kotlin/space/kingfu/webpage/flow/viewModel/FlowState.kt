package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.mutableStateListOf

data class FlowState(
    val banners: MutableList<Banner> = mutableStateListOf(),
    val header: Header = Header(
        title = TextData(),
        subtitle = TextData(),
        buttons = mutableStateListOf(
            ButtonData()
        ),
        image = ImageData()
    )
)

data class Header(
    val title: TextData,
    val subtitle: TextData,
    val buttons: MutableList<ButtonData>,
    val image: ImageData
)

data class TextData(
    val isEdit: Boolean = false,
    val text: String = ""
)

data class ButtonData(
    val text: String = "",
    val url: String = "",
    val isEdit: Boolean = false
)

data class ImageData(
    val isEdit: Boolean = false,
    val url: String = ""
)

data class Banner(
    val title: TextData,
    val subtitle: TextData,
    val body: TextData,
    val footer: TextData,
    val buttons: MutableList<ButtonData>,
    val image: ImageData
)

