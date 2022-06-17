package com.example.freshdesk.repository

import android.media.session.MediaSession
import com.example.freshdesk.api.RetrofitObject
import com.example.freshdesk.api.models.ReportBreakDownByTicketsTypeReport
import com.example.freshdesk.api.models.Token
import retrofit2.Response

class MainRepository {
    private val api = RetrofitObject.retrofitModule()

    suspend fun login(username: String, password: String): Response<Token> {
        return api.login(username, password)
    }
    suspend fun breakDnReport():Response<ReportBreakDownByTicketsTypeReport>{
        return api.reports()

    }    }