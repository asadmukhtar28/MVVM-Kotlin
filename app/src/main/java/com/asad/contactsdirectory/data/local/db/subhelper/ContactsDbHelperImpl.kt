package com.asad.contactsdirectory.data.local.db.subhelper

import com.asad.contactsdirectory.models.ContactsModel

abstract class ContactsDbHelperImpl : BaseDbHelper(), ContactsDbHelper {
    override fun deleteAllContacts() {
        mAppDatabase?.contactsDao()?.deleteAllContacts()
    }

    override fun insertContacts(contacts: List<ContactsModel>) {
        mAppDatabase?.contactsDao()?.insertContacts(contacts)
    }

    override fun getAllContacts(): List<ContactsModel>? {
        return mAppDatabase?.contactsDao()?.getAllContacts()
    }
}