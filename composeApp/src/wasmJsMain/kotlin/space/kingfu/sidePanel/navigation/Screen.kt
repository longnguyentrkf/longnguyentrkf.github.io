package space.kingfu.sidePanel.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    object Home: Screen

    @Serializable
    object Banners: Screen

    @Serializable
    object Banner: Screen
}

sealed interface Dialog {
    @Serializable
    data class DeleteBanner(
        val index: Int,
        val title: String,
        val text: String
    )

    @Serializable
    data class SetBannerName(
        val index: Int,
        val title: String,
        val text: String
    )

    @Serializable
    data class SetBannerType(
        val index: Int,
        val title: String,
        val text: String
    )
}