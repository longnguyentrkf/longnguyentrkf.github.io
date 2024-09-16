package space.kingfu.webpage.home.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import space.kingfu.webpage.ui.theme.ThemeType

class HomeViewModel: ViewModel() {

    var state by mutableStateOf(value = HomeState())
        private set

//    fun setTheme(theme: ThemeType){
//        state = state.copy(theme = if (theme == ThemeType.LIGHT) ThemeType.DARK else ThemeType.LIGHT)
//    }

    fun setFirstName(string: String){
        state = state.copy(firstName = string)
    }

    fun setLastName(string: String){
        state = state.copy(lastName = string)
    }

    fun setMessage(string: String){
        state = state.copy(message = string)
    }

}