package com.kingfuspace.main.core


//fun <T> MutableList<T>.move(selectedIndex: Int, targetedIndex: Int) {
//    val item = this[selectedIndex]
//    this.removeAt(selectedIndex)
//    this.add(targetedIndex.coerceAtLeast(minimumValue = 0), item)
//}

 fun <T> MutableList<T>.move(selectedIndex: Int, targetedIndex: Int) {
    val item = removeAt(selectedIndex)
    add(targetedIndex, item)
}
