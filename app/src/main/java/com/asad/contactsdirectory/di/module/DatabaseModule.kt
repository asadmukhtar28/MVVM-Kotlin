package com.asad.contactsdirectory.di.module

import android.content.Context
import androidx.room.Room
import com.asad.contactsdirectory.data.local.db.AppDatabase
import com.asad.contactsdirectory.di.DatabaseInfo
import com.asad.contactsdirectory.utils.CommonConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return CommonConstants.DB_NAME
    }

}
