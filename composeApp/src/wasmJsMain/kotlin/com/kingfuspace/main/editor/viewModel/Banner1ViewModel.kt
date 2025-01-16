package com.kingfuspace.main.editor.viewModel

import com.kingfuspace.main.editor.state.Banner

class Banner1ViewModel: EditorViewModel() {

    fun updateBannerName(bannerIndex: Int, newName: String) {
        val banner = state.banners[bannerIndex]

        // Update the banner name
        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(name = newName)
            is Banner.Banner2 -> banner
        }
    }
}