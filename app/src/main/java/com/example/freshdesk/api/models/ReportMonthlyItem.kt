package com.example.freshdesk.api.models

data class ReportMonthlyItem(
    val countOfClosedTicketsInThisMonth: Int,
    val countOfCreatedTickets: Int,
    val countOfCreatedTicketsWithTypeError: Int,
    val countOfCustomization: Int,
    val countOfTicketsWithOtherTypes: Int,
    val difference: Int,
    val nameOfMonth: String,
    val numberOfMonth: Int,
    val percentOfCountOfCustomization: Int,
    val percentOfTicketsWithOtherType: Int,
    val percentOfTicketsWithTypeError: Int
)