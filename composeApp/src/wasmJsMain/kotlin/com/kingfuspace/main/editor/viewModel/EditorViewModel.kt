package com.kingfuspace.main.editor.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import com.kingfuspace.main.core.move
import com.kingfuspace.main.core.swap
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.editor.state.LayoutType
import com.kingfuspace.main.editor.state.EditorState
import com.kingfuspace.main.editor.state.ImageData
import com.kingfuspace.main.editor.state.TextData

open class EditorViewModel : ViewModel() {

    var state by mutableStateOf(value = EditorState())
        private set

    private fun setCounter(int: Int) {
        state = state.copy(bannerCounter = int)
    }

    fun addBanner() {
        setCounter(int = state.bannerCounter + 1)
        state.banners.add(
            Banner.Banner1(
                id = state.bannerCounter,
                name = "Banner ${state.bannerCounter}",
                layoutType = null
            )
        )
    }

    fun deleteBanner(index: Int) = state.banners.removeAt(index)

    fun setBannerName(index: Int, name: String) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(name = name)
            is Banner.Banner2 -> banner.copy(name = name)
        }
    }

    fun setIndex(index: Int?) {
        state = state.copy(bannerIndex = index)
    }

    fun setType(index: Int, type: LayoutType) {
        state.banners[index] = when (type) {
            LayoutType.LAYOUT_1 -> Banner.Banner1(
                id = state.banners[index].id,
                name = state.banners[index].name,
                height = state.banners[index].height,
                layoutType = type
            )

            LayoutType.LAYOUT_2 -> Banner.Banner2(
                id = state.banners[index].id,
                name = state.banners[index].name,
                height = state.banners[index].height,
                layoutType = type
            )
        }
    }

    fun setHeight(index: Int, height: Dp) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(height = height)
            is Banner.Banner2 -> banner.copy(height = height)
        }
    }

    fun setIsReverse(index: Int, isReverse: Boolean) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(isReverse = isReverse)
            is Banner.Banner2 -> banner
        }
    }

    fun setImage(bannerIndex: Int, index: Int, url: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                images = banner.images.apply { this[index] = this[index].copy(url = url) }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun setImageName(bannerIndex: Int, componentIndex: Int, name: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                images = banner.images.apply {
                    this[componentIndex] = this[componentIndex].copy(name = name)
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun deleteImage(bannerIndex: Int, index: Int) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                images = banner.images.apply { removeAt(index) }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun addImage(index: Int) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                images = banner.images.apply { add(element = ImageData()) }
            )

            is Banner.Banner2 -> banner
        }
    }


    fun setTextValue(bannerIndex: Int, index: Int, text: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply { this[index] = this[index].copy(text = text) }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun setTextName(bannerIndex: Int, textIndex: Int, name: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply { this[textIndex] = this[textIndex].copy(name = name) }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun deleteText(bannerIndex: Int, index: Int) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(texts = banner.texts.apply { removeAt(index) })
            is Banner.Banner2 -> banner
        }
    }

    fun addText(index: Int) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(texts = banner.texts.apply { add(element = TextData()) })
            is Banner.Banner2 -> banner
        }
    }

    fun swapImages(bannerIndex: Int, selectedIndex: Int, targetedIndex: Int) {

        when (val banner = state.banners[bannerIndex]) {
            is Banner.Banner1 -> {
                banner.images.swap(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
            }

            is Banner.Banner2 -> {}
        }
    }


    fun moveImages(bannerIndex: Int, selectedIndex: Int, targetedIndex: Int) {
        when (val banner = state.banners[bannerIndex]) {
            is Banner.Banner1 -> {
                banner.images.move(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
            }

            is Banner.Banner2 -> {}
        }
    }

    fun swapTexts(bannerIndex: Int, selectedIndex: Int, targetedIndex: Int) {
        when (val banner = state.banners[bannerIndex]) {
            is Banner.Banner1 -> {
                banner.texts.swap(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
            }

            is Banner.Banner2 -> {}
        }
    }


    fun moveTexts(bannerIndex: Int, selectedIndex: Int, targetedIndex: Int) {
        when (val banner = state.banners[bannerIndex]) {
            is Banner.Banner1 -> {
                banner.texts.move(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
            }

            is Banner.Banner2 -> {}
        }
    }

    fun moveBanners(selectedIndex: Int, targetedIndex: Int) {
        state.banners.move(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
    }

    fun swapBanners(selectedIndex: Int, targetedIndex: Int) {
        state.banners.swap(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
    }



//     fun setImageScale(bannerIndex: Int, float: Float) {
//
//    }

}