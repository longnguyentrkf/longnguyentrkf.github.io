package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import space.kingfu.webpage.flow.model.FlowSection
import space.kingfu.webpage.flow.model.FlowStyleData
import space.kingfu.webpage.flow.model.FlowTextStyle
import space.kingfu.webpage.flow.util.FlowSectionType

class FlowViewModel : ViewModel() {

    var state by mutableStateOf(value = FlowState())
        private set

    fun addStyle() {

        val data =
            FlowSection(
                title = FlowTextStyle(),
                subtitle = FlowTextStyle(),
                body = FlowTextStyle(),
                footer = FlowTextStyle(),
                buttons = mutableStateListOf(FlowTextStyle()),
                image = FlowTextStyle()
            )
        state.details.add(element = data)
        state = state.copy(details = state.details)
    }

    fun removeButton(index: Int, buttonIndex: Int) {
        if (index !in state.details.indices || buttonIndex !in state.details[index].buttons.indices) return

        state.details[index].buttons.removeAt(buttonIndex)
    }

    fun addButton(sectionIndex: Int) {

        state.details[sectionIndex].buttons.add(FlowTextStyle())
    }


    fun setStyle(style: FlowStyleData) {
        if (style.index !in state.details.indices) return

        val currentDetail = state.details[style.index]

        val updatedFontDetails =
            when (style.section) {
                FlowSectionType.TITLE -> currentDetail.title.copy(
                    isEdit = style.isEdit ?: true,
                    text = style.text ?: currentDetail.title.text
                )

                FlowSectionType.SUBTITLE -> currentDetail.subtitle.copy(
                    isEdit = style.isEdit ?: true,
                    text = style.text ?: currentDetail.subtitle.text
                )

                FlowSectionType.BODY -> currentDetail.body.copy(
                    isEdit = style.isEdit ?: true,
                    text = style.text ?: currentDetail.body.text
                )

                FlowSectionType.FOOTER -> currentDetail.footer.copy(
                    isEdit = style.isEdit ?: true,
                    text = style.text ?: currentDetail.footer.text
                )

                FlowSectionType.BUTTONS -> {

                    if (style.buttonIndex == null || style.buttonIndex !in currentDetail.buttons.indices) return

                    currentDetail.buttons[style.buttonIndex].copy(
                        isEdit = style.isEdit ?: true,
                        text = style.text ?: currentDetail.buttons[style.buttonIndex].text,
                        buttonUrl = style.buttonUrl ?: ""
                    )

                }

                FlowSectionType.IMAGE -> currentDetail.image.copy(
                    isEdit = style.isEdit ?: true,
                    imageUrl = style.imageUrl
                )
            }

        val updatedDetails = when (style.section) {
            FlowSectionType.TITLE -> currentDetail.copy(title = updatedFontDetails)
            FlowSectionType.SUBTITLE -> currentDetail.copy(subtitle = updatedFontDetails)
            FlowSectionType.BODY -> currentDetail.copy(body = updatedFontDetails)
            FlowSectionType.FOOTER -> currentDetail.copy(footer = updatedFontDetails)
            FlowSectionType.BUTTONS -> {
                if (style.buttonIndex == null || style.buttonIndex !in currentDetail.buttons.indices) return
                val updatedButtons = currentDetail.buttons
                    .apply {
                        this[style.buttonIndex] = updatedFontDetails
                    }

                currentDetail.copy(buttons = updatedButtons)

            }

            FlowSectionType.IMAGE -> currentDetail.copy(image = updatedFontDetails)
        }
        state.details[style.index] = updatedDetails
    }

}