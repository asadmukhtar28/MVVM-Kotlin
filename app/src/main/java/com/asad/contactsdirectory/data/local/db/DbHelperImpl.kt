package com.asad.contactsdirectory.data.local.db

import com.asad.contactsdirectory.data.local.db.subhelper.ContactsDbHelperImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbHelperImpl @Inject constructor(appDatabase: AppDatabase) : ContactsDbHelperImpl(),
    DbHelper {
    init {
        mAppDatabase = appDatabase
    }
}