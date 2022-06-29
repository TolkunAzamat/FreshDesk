package com.example.freshdesk.api

import com.example.freshdesk.api.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @POST("/token")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<Token>
    @GET("/api/Reports/GetJsonReportBreakDownByTicketsTypeReport")// Разбивка отчетов по типам заявок
    suspend fun reports():Response<ReportBreakDownByTicketsTypeReport>
    @GET("/api/Reports/GetJsonReportMonthly")//очет по месяцам
    suspend fun monthlyReports():Response<List<ReportMonthly>>
    @GET("/api/Reports/GetJsonReportModularly")//отчет по модулям
    suspend fun moduleReports():Response<List<ReportModularly>>
    @GET("/api/Reports/GetJsonReportClientAndModule") //отчет по клиентам
    suspend fun clientsReports():Response<List<ReportClientAndModule>>
    @GET("/api/Reports/GetJsonReportInDynamic") //в динамике
    suspend fun dynamicReport():Response<List<ReportInDynamic>>
    @GET("/api/Reports/GetJsonReportByAgents") //заявки по агентам
    suspend fun agentsReports():Response<List<ReportByAgents>>

}