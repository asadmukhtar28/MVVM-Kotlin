package com.asad.contactsdirectory.managers

import com.asad.contactsdirectory.data.local.db.DbHelper
import com.asad.contactsdirectory.data.local.prefs.PreferencesHelper
import com.asad.contactsdirectory.data.remote.AppService
import com.asad.contactsdirectory.utils.ResourceProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val appService: AppService,
    private val preferencesHelper: PreferencesHelper,
    private val dbHelper: DbHelper
) : DataManager {

    override fun getResourceManager(): ResourceProvider {
        return resourceProvider
    }

    override fun getApiHelper(): AppService {
        return appService
    }

    override fun getDbHelper(): DbHelper {
        return dbHelper
    }

    override fun getPreferencesHelper(): PreferencesHelper {
       return  preferencesHelper
    }
}