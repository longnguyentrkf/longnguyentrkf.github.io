package com.kingfuspace.main.core


 fun <T> MutableList<T>.move(selectedIndex: Int, targetedIndex: Int) {
    val item = removeAt(selectedIndex)
    add(targetedIndex, item)
}
