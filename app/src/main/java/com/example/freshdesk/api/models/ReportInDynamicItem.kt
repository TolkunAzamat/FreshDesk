package com.example.freshdesk.api.models

data class ReportInDynamicItem(
    val forForMonthSet: Int,
    val forMonthkGet: Int,
    val forWeekGet: Int,
    val forWeekSet: Int,
    val percent: Int,
    val previosDayGet: Int,
    val previosDaySet: Int,
    val status: String,
    val total: Int
)