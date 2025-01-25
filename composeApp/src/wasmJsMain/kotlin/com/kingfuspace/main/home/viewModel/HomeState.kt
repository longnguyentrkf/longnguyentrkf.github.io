package com.kingfuspace.main.home.viewModel

import org.jetbrains.compose.resources.DrawableResource


data class HomeState(
    val firstName: String = "",
    val lastName: String = "",
    val message: String = "",
//    val header: Header = Header(
//        title1 = "Introducing Kingfuspace",
//        title2 = "Create your platform with cutting-edge technology",
//        image = Res.drawable.kingfuspace_logo_no_background
//    )
)

data class Header(
    val title1: String? = null,
    val title2: String? = null,
    val buttons: List<String>? = null,
    val image: DrawableResource? = null
)

