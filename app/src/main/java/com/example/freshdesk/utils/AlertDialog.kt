package com.example.freshdesk.utils

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import com.example.freshdesk.login.LoginActivity
import com.example.freshdesk.sharedPreferences.SharedPreferences

fun alertDialog(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle("Выйти")
    builder.setMessage("Хотите выйти?")
    builder.setIcon(android.R.drawable.ic_dialog_alert)
    builder.setPositiveButton("Нет") { dialogInterface, which ->
    }
    builder.setNegativeButton("Да") { dialogInterface, which ->
        context.startActivity(Intent(context, LoginActivity::class.java))
        val shared = SharedPreferences(context)
        shared.clean()
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}
