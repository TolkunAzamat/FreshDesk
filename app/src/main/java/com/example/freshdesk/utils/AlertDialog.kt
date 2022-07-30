package com.example.freshdesk.utils

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import com.example.freshdesk.login.LoginActivity
import com.example.freshdesk.utils.sharedPreferences.SharedPreferences

fun alertDialog(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle("Выйти")
    builder.setMessage("Хотите выйти?")
    builder.setNegativeButton("Нет") { _, _ ->
    }
    builder.setPositiveButton("Да") { _, _ ->
        context.startActivity(Intent(context, LoginActivity::class.java))
        val shared = SharedPreferences(context)
        shared.clean()
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}
