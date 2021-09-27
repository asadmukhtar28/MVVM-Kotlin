package com.asad.contactsdirectory.ui.contacts

import android.util.Log
import androidx.activity.viewModels
import com.asad.contactsdirectory.BR
import com.asad.contactsdirectory.R
import com.asad.contactsdirectory.databinding.ActivityContactsBinding
import com.asad.contactsdirectory.ui.base.BaseActivity
import com.asad.contactsdirectory.ui.contacts.adapter.ContactsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ContactsActivity :
    BaseActivity<ContactsViewModel, ActivityContactsBinding>(R.layout.activity_contacts),
    ContactsNavigator {
    @Inject
    lateinit var adapter: ContactsAdapter

    override val viewModel: ContactsViewModel by viewModels()

    override fun getBindingVariable() = BR.viewModel

    override fun initUi() {
        viewModel.setNavigator(this)
        bindings.rvContacts.adapter = adapter

        viewModel.contactList.observe(this,
            {
                viewModel.observableArrayList.addAll(it)
            })
    }
}