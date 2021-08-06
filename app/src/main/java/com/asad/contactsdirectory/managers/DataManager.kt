package com.asad.contactsdirectory.managers

import com.asad.contactsdirectory.data.local.db.DbHelper
import com.asad.contactsdirectory.data.local.prefs.PreferencesHelper
import com.asad.contactsdirectory.data.remote.AppService
import com.asad.contactsdirectory.utils.ResourceProvider

interface DataManager {
    fun getApiHelper(): AppService
    fun getResourceManager(): ResourceProvider
    fun getPreferencesHelper(): PreferencesHelper
    fun getDbHelper(): DbHelper
}