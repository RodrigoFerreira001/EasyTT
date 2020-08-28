package com.catbit.easytt.repositories

import android.content.Context
import android.content.Context.MODE_PRIVATE

class SharedPreferencesRepository (
    private val application: Context,
    private val preferenceName: String
) {
    fun <T> save(key: String, value: T, mode: Int = MODE_PRIVATE): Unit {
        application.getSharedPreferences(preferenceName, mode)
            .edit().apply {
                when (value) {
                    is String   -> putString(key, value)
                    is Int      -> putInt(key, value)
                    is Long     -> putLong(key, value)
                    is Boolean  -> putBoolean(key, value)
                    is Float    -> putFloat(key, value)
                }
                apply()
            }
    }

    fun load(key: String, mode: Int = MODE_PRIVATE): Any? {
        return application.getSharedPreferences(preferenceName, mode).all[key]
    }

    fun containsKey(key: String, mode: Int = MODE_PRIVATE): Boolean {
        return application.getSharedPreferences(preferenceName, mode).contains(key)
    }
}