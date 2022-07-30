package com.example.freshdesk.utils.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private val APP_NAME = "SharedPreferences"
    private var pref: SharedPreferences =
        context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
    var token: String?
        get() = pref.getString("token", null)
        set(value) = pref.edit().putString("token", value).apply()
    var username: String?
        get() = pref.getString("username", null)
        set(value) = pref.edit().putString("username", value).apply()

    fun clean() {
        pref.edit().clear().apply()
    }
}