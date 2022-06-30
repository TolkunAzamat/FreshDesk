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
    @GET("/api/Reports/GetJsonReportBreakDownByTicketsTypeReport")
    suspend fun reports():Response<ReportBreakDownByTicketsTypeReport>
    @GET("/api/Reports/GetJsonReportMonthly")
    suspend fun monthlyReports():Response<List<ReportMonthly>>
    @GET("/api/Reports/GetJsonReportModularly")
    suspend fun moduleReports():Response<List<ReportModularly>>
    @GET("/api/Reports/GetJsonReportClientAndModule")
    suspend fun clientsReports():Response<List<ReportClientAndModule>>
    @GET("/api/Reports/GetJsonReportInDynamic")
    suspend fun dynamicReport():Response<List<ReportInDynamic>>
    @GET("/api/Reports/GetJsonReportByAgents")
    suspend fun agentsReports():Response<List<ReportByAgents>>

}