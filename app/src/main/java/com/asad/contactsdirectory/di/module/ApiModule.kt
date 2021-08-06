package com.asad.contactsdirectory.di.module

import com.asad.contactsdirectory.data.local.prefs.PreferencesHelper
import com.asad.contactsdirectory.data.remote.AppService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofitService(preferencesHelper: PreferencesHelper): AppService =
        Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL_API)
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(ApiHttpClient().getHTTPClient(preferencesHelper))
            .build()
            .create(AppService::class.java)


}
