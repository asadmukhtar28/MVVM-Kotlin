package com.asad.contactsdirectory.data.local.db.subhelper

import com.asad.contactsdirectory.models.ContactsModel

interface ContactsDbHelper {
    fun insertContacts(contacts: List<ContactsModel>)
    fun deleteAllContacts()
    fun getAllContacts(): List<ContactsModel>?
}