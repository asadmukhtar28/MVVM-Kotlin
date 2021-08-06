package com.asad.contactsdirectory.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asad.contactsdirectory.models.ContactsModel

@Dao
abstract class ContactsDao : BaseDao<ContactsModel> {
    @Insert
    abstract fun insertContacts(contacts: List<ContactsModel>)

    @Query("Select *from contacts")
    abstract fun getAllContacts(): List<ContactsModel>

    @Query("Delete from contacts")
    abstract fun deleteAllContacts()
}