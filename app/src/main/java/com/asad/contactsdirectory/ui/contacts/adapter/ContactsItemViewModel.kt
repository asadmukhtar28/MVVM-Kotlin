package com.asad.contactsdirectory.ui.contacts.adapter

import androidx.lifecycle.MutableLiveData
import com.asad.contactsdirectory.models.ContactsModel

class ContactsItemViewModel(model: ContactsModel) {
    val name = MutableLiveData(model.name)
    val email = MutableLiveData(model.email)
    val mobile = MutableLiveData("mobile : " + model.phone.mobile)
    val office = MutableLiveData("office : " + model.phone.office)
    val home = MutableLiveData("home : " + model.phone.home)
}