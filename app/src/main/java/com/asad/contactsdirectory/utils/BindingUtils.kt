package com.asad.contactsdirectory.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.asad.contactsdirectory.interfaces.AdapterUpdateListener


object BindingUtils {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(
        imageView: ImageView,
        url: String
    ) {

    }

    @BindingAdapter("addItems")
    @JvmStatic
    fun <T> addItems(recyclerView: RecyclerView, list: MutableLiveData<List<T>>) {
        list.value?.let {
            if (it.size > 0) {
                (recyclerView.adapter as AdapterUpdateListener).clearItems()
                (recyclerView.adapter as AdapterUpdateListener).addItems(it)
            }
        }
    }
}