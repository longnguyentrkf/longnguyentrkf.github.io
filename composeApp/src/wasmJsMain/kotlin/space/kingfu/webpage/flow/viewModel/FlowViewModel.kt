package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import space.kingfu.webpage.flow.util.FlowSectionType
import space.kingfu.webpage.flow.util.FlowStyle

class FlowViewModel : ViewModel() {


    var state by mutableStateOf(value = FlowState())
        private set

    fun addDetail() {
//        state.details.add(
//            Details(
//                fontDetails = FontDetails()
//            )
//        )
//        state = state.copy(details = state.details)
    }


    fun setSection(
        index: Int,
        section: FlowSectionType,
        newValue: Any,
        buttonIndex: Int?,
        url: String?
    ) {
        if (index in state.details.indices) {
            val currentDetail = state.details[index]

            val details = when (section) {
                FlowSectionType.TITLE -> currentDetail.copy(
                    title = currentDetail.title.copy(
                        text = newValue as String
                    )
                )

                FlowSectionType.SUBTITLE -> currentDetail.copy(
                    subtitle = currentDetail.subtitle.copy(
                        text = newValue as String
                    )
                )

                FlowSectionType.BODY -> currentDetail.copy(
                    body = currentDetail.body.copy(
                        text = newValue as String
                    )
                )

                FlowSectionType.FOOTER -> currentDetail.copy(
                    footer = currentDetail.footer.copy(
                        text = newValue as String
                    )
                )

                FlowSectionType.BUTTONS -> {
                    if (buttonIndex in currentDetail.buttons.indices && buttonIndex != null) {
                        val updatedButtons = currentDetail.buttons.toMutableList().apply {
                            this[buttonIndex] = this[buttonIndex].copy(
                                text = if (url != null) this[buttonIndex].text else newValue as? String
                                    ?: this[buttonIndex].text,
                                url = url ?: this[buttonIndex].url
                            )
                        }
                        currentDetail.copy(buttons = updatedButtons)
                    } else {
                        currentDetail
                    }
                }
            }

            state.details[index] = details
        }
    }


    fun setStyle(
        index: Int,
        section: FlowSectionType,
        style: FlowStyle,
        newValue: Any,
        buttonIndex: Int? = null,
        url: String? = null
    ) {
        if (index in state.details.indices) {
            val currentDetail = state.details[index]

            val updatedFontDetails = when (style) {
                FlowStyle.IS_EDIT -> when (section) {
                    FlowSectionType.TITLE -> currentDetail.title.copy(isEdit = newValue as Boolean)
                    FlowSectionType.SUBTITLE -> currentDetail.subtitle.copy(isEdit = newValue as Boolean)
                    FlowSectionType.BODY -> currentDetail.body.copy(isEdit = newValue as Boolean)
                    FlowSectionType.FOOTER -> currentDetail.footer.copy(isEdit = newValue as Boolean)
                    FlowSectionType.BUTTONS -> {
                        if (buttonIndex in currentDetail.buttons.indices && buttonIndex != null) {
                            currentDetail.buttons[buttonIndex].copy(
                                isEdit = newValue as Boolean,
                                url = url ?: ""
                            )
                        } else {
                            return
                        }
                    }
                }
            }

            val updatedDetails = when (section) {
                FlowSectionType.TITLE -> currentDetail.copy(title = updatedFontDetails)
                FlowSectionType.SUBTITLE -> currentDetail.copy(subtitle = updatedFontDetails)
                FlowSectionType.BODY -> currentDetail.copy(body = updatedFontDetails)
                FlowSectionType.FOOTER -> currentDetail.copy(footer = updatedFontDetails)
                FlowSectionType.BUTTONS -> {
                    if (buttonIndex in currentDetail.buttons.indices && buttonIndex != null) {
                        val updatedButtons = currentDetail.buttons.toMutableList().apply {
                            this[buttonIndex] = updatedFontDetails
                        }
                        currentDetail.copy(
                            buttons = updatedButtons,
                        )

                    } else {
                        currentDetail
                    }
                }
            }

            state.details[index] = updatedDetails
        }
    }


}