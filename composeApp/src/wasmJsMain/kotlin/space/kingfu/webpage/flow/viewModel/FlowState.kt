package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.mutableStateListOf
import space.kingfu.webpage.flow.model.FlowSection
import space.kingfu.webpage.flow.model.FlowTextStyle

data class FlowState(
    val details: MutableList<FlowSection> = mutableStateListOf(
        FlowSection(
            title = FlowTextStyle(),
            subtitle = FlowTextStyle(),
            body = FlowTextStyle(),
            footer = FlowTextStyle(),
            buttons = mutableListOf(
                FlowTextStyle()
            )
        )
    )
)