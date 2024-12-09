package space.kingfu.main.home.viewModel

import kingfu.composeapp.generated.resources.Res
import kingfu.composeapp.generated.resources.kingfu_no_background
import org.jetbrains.compose.resources.DrawableResource


data class HomeState(
    val firstName: String = "",
    val lastName: String = "",
    val message: String = "",
    val header: Header = Header(
        title1 = "Introducing KingFu",
        title2 = "Create your platform with cutting-edge technology",
        image = Res.drawable.kingfu_no_background
//        image = Res.drawable.weatherai
    )
)

data class Header(
    val title1: String? = null,
    val title2: String? = null,
    val buttons: List<String>? = null,
    val image: DrawableResource? = null
)

