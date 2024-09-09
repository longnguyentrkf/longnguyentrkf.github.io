package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.mutableStateListOf
import space.kingfu.webpage.flow.model.Details

data class FlowState(
    val details: MutableList<Details> = mutableStateListOf(Details())
)