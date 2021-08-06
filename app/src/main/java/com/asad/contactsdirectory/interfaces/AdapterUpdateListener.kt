package com.asad.contactsdirectory.interfaces

interface AdapterUpdateListener {
    fun clearItems()
    fun <T> addItems(items: List<T>, isLoadMore: Boolean = false)
    fun <T> addItem(item: T) {}
    fun removeItem(position: Int) {}
}