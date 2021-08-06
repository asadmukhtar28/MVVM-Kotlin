package com.asad.contactsdirectory.ui.contacts

import com.asad.contactsdirectory.managers.DataManager
import com.asad.contactsdirectory.models.ContactsModel
import com.asad.contactsdirectory.models.base.ResponsePacket
import com.asad.contactsdirectory.models.base.State
import com.asad.contactsdirectory.ui.base.BaseRepository
import javax.inject.Inject

class ContactsRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {

    suspend fun fetchContacts(): State<ResponsePacket<List<ContactsModel>>> {
        return makeApiCall { dataManager.getApiHelper().fetchContacts() }
    }

    suspend fun fetchContactsFromDb(): List<ContactsModel>? {
        return dataManager.getDbHelper().getAllContacts()
    }
}