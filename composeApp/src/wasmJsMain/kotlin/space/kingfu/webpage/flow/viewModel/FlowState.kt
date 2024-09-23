package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.mutableStateListOf
import space.kingfu.webpage.home.components.Header

data class FlowState(
    val banners: MutableList<Banner> = mutableStateListOf(),
    val header: Header = Header(
        headerTitle1 = TextData(),
        headerTitle2 = TextData(),
        buttons = mutableStateListOf(ButtonData()),
        image = ImageData()
    ),
    val topBarTitle: TextData = TextData(),
//    val footer: Footer =
)

data class Header(
    val headerTitle1: TextData,
    val headerTitle2: TextData,
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
    val image: ImageData,
    val bannerTitle: TextData
)



