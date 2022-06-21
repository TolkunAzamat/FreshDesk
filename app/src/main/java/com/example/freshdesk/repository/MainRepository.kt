package com.example.freshdesk.repository

import android.media.session.MediaSession
import com.example.freshdesk.api.RetrofitObject
import com.example.freshdesk.api.models.*
import retrofit2.Response

class MainRepository {
    private val api = RetrofitObject.retrofitModule()

    suspend fun login(username: String, password: String): Response<Token> {
        return api.login(username, password)
    }
    suspend fun breakDnReport():Response<ReportBreakDownByTicketsTypeReport>{
        return api.reports()
    }
    suspend fun monthlyStatistics(): Response<List<ReportMonthlyItem>> {
        return api.monthlyReports()
    }
    suspend fun modularlyReports(): Response<List<ReportModularlyItem>> {
        return api.modularlyReports()
    }
    suspend fun clientAndModule():Response<List<ReportClientAndModuleItem>>{
        return api.clientAndModule()
    }
    suspend fun agentsReports():Response<List<ReportByAgentsItem>>{
        return api.agentsReports()
    }
}