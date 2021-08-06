package com.asad.contactsdirectory.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asad.contactsdirectory.data.local.db.dao.ContactsDao
import com.asad.contactsdirectory.models.ContactsModel

@Database(entities = [ContactsModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}