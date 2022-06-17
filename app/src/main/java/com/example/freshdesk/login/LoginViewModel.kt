package com.example.freshdesk.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.App
import com.example.freshdesk.App.Companion.getContext
import com.example.freshdesk.repository.MainRepository
import com.example.freshdesk.sharedPreferences.SharedPreferences
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val repository = MainRepository()

    fun login(username: String, password: String, isSuccess: () -> Unit) {
        viewModelScope.launch {
            repository.login(username, password).let {
                if (it.isSuccessful) {
                    isSuccess.invoke()
                   SharedPreferences(getContext()).token = it.body()?.access_token

                    //access token нужно сохранить
                }
            }
        }
    }
}