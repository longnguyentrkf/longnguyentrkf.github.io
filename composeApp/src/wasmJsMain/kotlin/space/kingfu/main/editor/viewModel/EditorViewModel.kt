package space.kingfu.main.editor.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import space.kingfu.main.editor.state.Banner
import space.kingfu.main.editor.state.BannerType
import space.kingfu.main.editor.state.EditorState
import space.kingfu.main.editor.state.ImageData
import space.kingfu.main.editor.state.TextData

class EditorViewModel : ViewModel() {

    var state by mutableStateOf(value = EditorState())
        private set


    fun setCounter(int: Int) {
        state = state.copy(counter = int)
    }

    fun addBanner() {
        setCounter(int = state.counter + 1)
        state.banners.add(
            Banner.Banner1(
                id = state.counter,
                name = "Banner ${state.counter}",
                type = null
            )
        )
    }

    fun deleteBanner(index: Int) {
        state.banners.removeAt(index)
    }

    fun setBannerIndex(index: Int?) {
        state = state.copy(bannerIndex = index)
    }

    fun setBannerName(index: Int, newName: String) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(name = newName)
            is Banner.Banner2 -> banner.copy(name = newName)

        }
    }

    fun setBannerType(index: Int, type: BannerType) {

        val currentBanner = state.banners[index]

        state.banners[index] = when (type) {
            BannerType.TYPE_1 -> Banner.Banner1(
                id = currentBanner.id,
                name = currentBanner.name,
                height = currentBanner.height,
                type = type,
                image = mutableStateListOf(ImageData()),
                texts = mutableStateListOf(TextData(name = "Text")),
                buttons = mutableStateListOf()
            )

            BannerType.TYPE_2 -> Banner.Banner2(
                id = currentBanner.id,
                name = currentBanner.name,
                height = currentBanner.height,
                type = type,
                textsBody = mutableStateListOf()
            )
        }
    }

    fun setBannerHeight(index: Int, height: Dp) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(height = height)
            is Banner.Banner2 -> banner.copy(height = height)
        }
    }

    fun setBannerIsReverse(index: Int, isReverse: Boolean) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(isReverse = isReverse)
            is Banner.Banner2 -> banner
        }
    }

    fun setBannerImage(bannerIndex: Int, index: Int, url: String) {
        val banner = state.banners[bannerIndex]

        state.banners[bannerIndex] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                image = banner.image.apply {
                    this[index] = this[index].copy(url = url)
                }
            )

            is Banner.Banner2 -> banner
        }
    }

    fun addBannerImage(index: Int) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                image = banner.image.apply {
                    add(element = ImageData())
                }
            )

            is Banner.Banner2 -> banner
        }
    }


    fun setBannerText(bannerIndex: Int, index: Int, newText: String) {
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

    fun setBannerTextName(bannerIndex: Int, textIndex: Int, newName: String) {
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

    fun removeBannerText(bannerIndex: Int, textIndex: Int) {
        val updatedBanners = state.banners.apply {
            val banner = this[bannerIndex]
            this[bannerIndex] = when (banner) {
                is Banner.Banner1 -> banner.copy(
                    texts = banner.texts.apply {
                        if (textIndex in indices) {
                            removeAt(textIndex)
                        }
                    }
                )

                is Banner.Banner2 -> banner
            }
        }
        state = state.copy(banners = updatedBanners)
    }

    fun addBannerText(index: Int) {
        val banner = state.banners[index]

        state.banners[index] = when (banner) {
            is Banner.Banner1 -> banner.copy(
                texts = banner.texts.apply {
                    add(element = TextData(name = "Text"))
                }
            )

            is Banner.Banner2 -> banner
        }
    }
}