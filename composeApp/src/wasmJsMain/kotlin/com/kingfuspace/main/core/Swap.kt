package com.kingfuspace.main.core

fun <T> MutableList<T>.swap(selectedIndex: Int, targetedIndex: Int) {
    val temp = this[selectedIndex]
    this[selectedIndex] = this[targetedIndex]
    this[targetedIndex] = temp
}

