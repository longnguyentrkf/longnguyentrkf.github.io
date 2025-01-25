package com.kingfuspace.sidePanel.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    object Home: Screen

    @Serializable
    object Banners: Screen

    @Serializable
    object Banner: Screen

    @Serializable
    data class Component(
        val bannerIndex: Int,
        val componentIndex: Int
    ): Screen

    @Serializable
    data class ComponentImage(
        val index: Int
    ): Screen

    @Serializable
    data class ComponentText(
        val index: Int
    ): Screen

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
        val bannerIndex: Int,
        val title: String,
        val text: String,
    )

    @Serializable
    data class SetTextName(
        val bannerIndex: Int,
        val componentIndex: Int,
        val title: String,
        val text: String,
    )

    @Serializable
    data class SetImageName(
        val bannerIndex: Int,
        val componentIndex: Int,
        val title: String,
        val text: String
    )

    @Serializable
    data class SetLayoutType(
        val index: Int,
        val title: String,
        val text: String
    )

    @Serializable
    data class SetComponentType(
        val bannerIndex: Int,
        val componentIndex: Int,
        val title: String,
        val text: String
    )

    @Serializable
    data class MoveImage(
        val index: Int
    )

    @Serializable
    data class MoveText(
        val index: Int
    )

    @Serializable
    data class MoveBanners(
        val index: Int
    )


}