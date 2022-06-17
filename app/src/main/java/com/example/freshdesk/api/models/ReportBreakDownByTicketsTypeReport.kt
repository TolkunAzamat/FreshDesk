package com.example.freshdesk.api.models

data class ReportBreakDownByTicketsTypeReport(
    val changeRequestCount: Int,
    val changeRequestPercent: Double,
    val errorBugCount: Int,
    val errorBugPercent: Double,
    val name: String,
    val newFunctionalityRequestCount: Int,
    val newFunctionalityRequestPercent: Double,
    val parametrizationQuestionCount: Int,
    val parametrizationQuestionPercent: Int,
    val systemQuestionCount: Int,
    val systemQuestionPercent: Double,
    val totalCount: Int,
    val totalPercent: Int
)