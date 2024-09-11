package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.mutableStateListOf
import space.kingfu.webpage.flow.model.FlowSection

data class FlowState(
    val details: MutableList<FlowSection> = mutableStateListOf()
)