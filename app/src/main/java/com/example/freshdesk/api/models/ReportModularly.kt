package com.example.freshdesk.api.models

data class ReportModularly(
    val countOfClosedStatus: Int,
    val countOfOpenedStatus: Int,
    val countOfOtherStatus: Int,
    val name: String,
    val percent: Double,
    val total: Int
)