package com.asad.contactsdirectory.ui.contacts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asad.contactsdirectory.databinding.ItemContactsBinding
import com.asad.contactsdirectory.interfaces.AdapterUpdateListener
import com.asad.contactsdirectory.models.ContactsModel
import com.asad.contactsdirectory.ui.base.BaseViewHolder
import javax.inject.Inject

class ContactsAdapter @Inject constructor() :
    RecyclerView.Adapter<ContactsAdapter.ItemViewHolder>(), AdapterUpdateListener<ContactsModel> {
    val contactList = ArrayList<ContactsModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemContactsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun clearItems() {
        contactList.clear()
        notifyDataSetChanged()
    }

    override fun addItems(items: List<ContactsModel>, isLoadMore: Boolean) {
        if (!isLoadMore) {
            clearItems()
            contactList.addAll(items as Collection<ContactsModel>)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(val binding: ItemContactsBinding) : BaseViewHolder(binding.root) {
        override fun onBind(position: Int) {
            binding.viewModel = ContactsItemViewModel(contactList[position])
            binding.executePendingBindings()
        }
    }
}