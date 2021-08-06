package com.asad.contactsdirectory.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelperImpl @Inject constructor(val context: Context, prefFileName: String) :
    PreferencesHelper {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)


    private fun putString(key: String, value: String) {
        prefs.edit { putString(key, value) }
    }

    override fun clearPreferences() {
        prefs.edit().clear().apply()
    }

}