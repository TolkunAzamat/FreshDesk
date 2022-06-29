package com.example.freshdesk.repository

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
    suspend fun monthlyStatistics(): Response<List<ReportMonthly>> {
        return api.monthlyReports()
    }
    suspend fun modularlyReports(): Response<List<ReportModularly>> {
        return api.modularlyReports()
    }
    suspend fun clientAndModule():Response<List<ReportClientAndModule>>{
        return api.clientAndModule()
    }
    suspend fun agentsReports():Response<List<ReportByAgents>>{
        return api.agentsReports()
    }
    suspend fun dynamicReport():Response<List<ReportInDynamic>>{
        return api.dynamicReport()
    }
}