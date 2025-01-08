package com.kingfuspace.main.editor.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import com.kingfuspace.main.core.move
import com.kingfuspace.main.core.swap
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.editor.state.BannerType
import com.kingfuspace.main.editor.state.EditorState
import com.kingfuspace.main.editor.state.ImageData
import com.kingfuspace.main.editor.state.TextData

class EditorViewModel : ViewModel() {

    var state by mutableStateOf(value = EditorState())
        private set


    fun setCounter(int: Int) {
        state = state.copy(bannerCounter = int)
    }

    fun addBanner() {
        setCounter(int = state.bannerCounter + 1)
        state.banners.add(
            Banner.Banner1(
                id = state.bannerCounter,
                name = "Banner ${state.bannerCounter}",
                bannerType = null
            )
        )
    }

    fun deleteBanner(index: Int) {
        state.banners.removeAt(index)
    }

    fun setIndex(index: Int?) {
        state = state.copy(bannerIndex = index)
    }

    fun setName(index: Int, newName: String) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(name = newName)
            is Banner.Banner2 -> banner.copy(name = newName)
        }
    }

    fun setType(index: Int, type: BannerType) {

        val currentBanner = state.banners[index]

        state.banners[index] = when (type) {
            BannerType.TYPE_1 -> Banner.Banner1(
                id = currentBanner.id,
                name = currentBanner.name,
                height = currentBanner.height,
                bannerType = type,
                images = mutableStateListOf(ImageData()),
                texts = mutableStateListOf(TextData()),
                buttons = mutableStateListOf()
            )

            BannerType.TYPE_2 -> Banner.Banner2(
                id = currentBanner.id,
                name = currentBanner.name,
                height = currentBanner.height,
                bannerType = type,
                textsBody = mutableStateListOf()
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
                images = banner.images.apply {
                    this[index] = this[index].copy(url = url)
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun setImageName(bannerIndex: Int, componentIndex: Int, name: String){
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when(banner){
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
                images = banner.images.apply {
                    if (index in indices) {
                        removeAt(index)
                    }
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun addImage(index: Int) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                images = banner.images.apply {
                    add(element = ImageData())
                }
            )

            is Banner.Banner2 -> banner
        }
    }


    fun setTextValue(bannerIndex: Int, index: Int, newText: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply {
                    this[index] = this[index].copy(text = newText)
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun setTextName(bannerIndex: Int, textIndex: Int, newName: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply {
                    this[textIndex] = this[textIndex].copy(name = newName)
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun deleteText(bannerIndex: Int, index: Int) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply {
                    if (index in indices) {
                        removeAt(index)
                    }
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun addText(index: Int) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply {
                    add(element = TextData())
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun swapImages(selectedIndex: Int, targetedIndex: Int) {
        val bannerIndex = state.bannerIndex ?: return

        val banner = state.banners[bannerIndex]

        when (banner) {
            is Banner.Banner1 -> {
                banner.images.swap(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
            }

            is Banner.Banner2 -> {}
        }
    }


    fun moveImages(selectedIndex: Int, targetIndex: Int) {
        val bannerIndex = state.bannerIndex ?: return

        val banner = state.banners[bannerIndex]

        when (banner) {
            is Banner.Banner1 -> {
                banner.images.move(selectedIndex = selectedIndex, targetedIndex = targetIndex)
            }

            is Banner.Banner2 -> {}
        }
    }

    fun swapTexts(selectedIndex: Int, targetedIndex: Int) {
        val bannerIndex = state.bannerIndex ?: return

        val banner = state.banners[bannerIndex]

        when (banner) {
            is Banner.Banner1 -> {
                banner.texts.swap(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
            }

            is Banner.Banner2 -> {}
        }
    }


    fun moveTexts(selectedIndex: Int, targetIndex: Int) {
        val bannerIndex = state.bannerIndex ?: return

        val banner = state.banners[bannerIndex]

        when (banner) {
            is Banner.Banner1 -> {
                banner.texts.move(selectedIndex = selectedIndex, targetedIndex = targetIndex)
            }

            is Banner.Banner2 -> {}
        }
    }

    fun moveBanners(selectedIndex: Int, targetedIndex: Int){
        state.banners.move(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
    }

    fun swapBanners(selectedIndex: Int, targetedIndex: Int){
        state.banners.swap(selectedIndex = selectedIndex, targetedIndex = targetedIndex)
    }



}