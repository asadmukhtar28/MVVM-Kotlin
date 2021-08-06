package com.asad.contactsdirectory.di

import android.app.Application
import android.content.Context
import com.asad.contactsdirectory.data.local.db.DbHelper
import com.asad.contactsdirectory.data.local.db.DbHelperImpl
import com.asad.contactsdirectory.data.local.prefs.PreferencesHelper
import com.asad.contactsdirectory.data.local.prefs.PreferencesHelperImpl
import com.asad.contactsdirectory.managers.DataManager
import com.asad.contactsdirectory.managers.DataManagerImpl
import com.asad.contactsdirectory.utils.CommonConstants
import com.asad.contactsdirectory.utils.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    fun providePreferenceName(): String {
        return CommonConstants.PREF_NAME
    }

    @Singleton
    @Provides
    fun providePreferenceHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper {
        return preferencesHelperImpl
    }

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context.applicationContext)
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManagerImpl: DataManagerImpl): DataManager {
        return dataManagerImpl
    }

    @Singleton
    @Provides
    fun provideDbHelper(dbHelperImpl: DbHelperImpl): DbHelper {
        return dbHelperImpl
    }
}