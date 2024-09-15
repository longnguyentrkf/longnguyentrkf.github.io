package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FlowViewModel : ViewModel() {

    var state by mutableStateOf(value = FlowState())
        private set

    fun addStyle() {
        val data =
            Banner(
                title = TextData(),
                subtitle = TextData(),
                body = TextData(),
                footer = TextData(),
                buttons = mutableStateListOf(ButtonData()),
                image = ImageData()
            )
        state.banners.add(element = data)
        state = state.copy(banners = state.banners)
    }

    fun removeButton(index: Int, buttonIndex: Int) {
        state.banners[index].buttons.removeAt(buttonIndex)
    }

    fun addButton(index: Int) {
        state.banners[index].buttons.add(ButtonData())
    }

    fun setTitle(index: Int, text: TextData) {
        val banner = state.banners[index]

        val title = banner.title.copy(
            text = text.text,
            isEdit = text.isEdit
        )

        state = state.copy(banners = state.banners.apply {
            set(
                index = index,
                element = banner.copy(title = title)
            )
        })
    }

    fun setSubtitle(index: Int, text: TextData) {
        val banner = state.banners[index]

        val subtitle = banner.subtitle.copy(
            text = text.text,
            isEdit = text.isEdit
        )

        state = state.copy(banners = state.banners.apply {
            set(
                index = index,
                element = banner.copy(subtitle = subtitle)
            )
        })
    }

    fun setBody(index: Int, text: TextData) {
        val banner = state.banners[index]

        val body = banner.body.copy(
            text = text.text,
            isEdit = text.isEdit
        )

        state = state.copy(banners = state.banners.apply {
            set(
                index = index,
                element = banner.copy(body = body)
            )
        })
    }


    fun setFooter(index: Int, text: TextData) {
        val banner = state.banners[index]

        val footer = banner.footer.copy(
            text = text.text,
            isEdit = text.isEdit
        )

        state = state.copy(banners = state.banners.apply {
            set(
                index = index,
                element = banner.copy(footer = footer)
            )
        })
    }

    fun setButtons(
        index: Int,
        buttonIndex: Int,
        buttonData: ButtonData,
    ) {
        if (buttonIndex !in state.banners[index].buttons.indices) return

        val banner = state.banners[index]

        val buttons = banner.buttons.apply {
            set(
                buttonIndex,
                banner.buttons[buttonIndex].copy(
                    text = buttonData.text,
                    url = buttonData.url,
                    isEdit = buttonData.isEdit
                )
            )
        }

        state = state.copy(banners = state.banners.apply {
            set(
                index = index,
                banner.copy(buttons = buttons)
            )
        })
    }

    fun setImage(index: Int, image: ImageData) {
        val banner = state.banners[index]

        val updatedImage = banner.image.copy(
            url = image.url,
            isEdit = image.isEdit
        )

        state = state.copy(banners = state.banners.apply {
            set(
                index,
                banner.copy(image = updatedImage)
            )
        })
    }

    fun setImageHeader(image: ImageData) {
        state = state.copy(
            header = state.header.copy(
                image = state.header.image.copy(
                    isEdit = image.isEdit,
                    url = image.url
                )
            )
        )
    }


    fun setTitleHeader(text: TextData) {
        state = state.copy(
            header = state.header.copy(
                title = state.header.title.copy(
                    isEdit = text.isEdit,
                    text = text.text
                )
            )
        )
    }

    fun setSubtitleHeader(text: TextData) {
        state = state.copy(
            header = state.header.copy(
                subtitle = state.header.subtitle.copy(
                    isEdit = text.isEdit,
                    text = text.text
                )
            )
        )
    }

    fun setButtonsHeader(index: Int, button: ButtonData) {
        state = state.copy(
            header = state.header.copy(
                buttons = state.header.buttons.apply { this[index] = button }
            )
        )
    }

    fun addButtonHeader(){
        state.header.buttons.add(element = ButtonData())
    }

    fun removeButtonHeader(index: Int){
        state.header.buttons.removeAt(index)
    }


}