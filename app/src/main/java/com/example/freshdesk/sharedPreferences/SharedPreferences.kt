package com.example.freshdesk.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private val APP_NAME="SharedPreferences"
    private var pref: SharedPreferences = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
    var token:String?
        get()=pref.getString("token",null)
        set(value)=pref.edit().putString("token",value).apply()

}