package space.kingfu.webpage.flow.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import space.kingfu.webpage.flow.model.Details

class FlowViewModel: ViewModel() {


    var state by mutableStateOf(value = FlowState())
        private set

    fun addDetail() {
        state.details.add(Details())
        state = state.copy(details = state.details)
    }

    fun setTitleFirst(index: Int, first: String){
        if (index in state.details.indices) {
            val currentDetail = state.details[index]

            val updatedDetail = currentDetail.copy(
                title = currentDetail.title.copy(first = first)
            )

            state.details[index] = updatedDetail
        }
    }

    fun setTitleSecond(index: Int, second: Boolean ){
        if (index in state.details.indices) {
            val currentDetail = state.details[index]

            val updatedDetail = currentDetail.copy(
                title = currentDetail.title.copy(second = second)
            )

            state.details[index] = updatedDetail

        }
    }



    fun setSubtitleFirst(index: Int, first: String){
        if (index in state.details.indices) {
            val currentDetail = state.details[index]

            val updatedDetail = currentDetail.copy(
                subtitle = currentDetail.subtitle.copy(first = first)
            )

            state.details[index] = updatedDetail
        }
    }

    fun setSubtitleSecond(index: Int, second: Boolean ){
        if (index in state.details.indices) {
            val currentDetail = state.details[index]

            val updatedDetail = currentDetail.copy(
                subtitle = currentDetail.subtitle.copy(second = second)
            )

            state.details[index] = updatedDetail

        }
    }




}