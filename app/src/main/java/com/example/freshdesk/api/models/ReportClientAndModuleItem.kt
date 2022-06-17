package com.example.freshdesk.api.models

data class ReportClientAndModuleItem(
    val accountingDepartment: Int,
    val acp: Int,
    val aur: Int,
    val basicGuides: Int,
    val carts: Int,
    val cashbox: Int,
    val clients: Int,
    val complaens: Int,
    val credits: Int,
    val depositsSettlement: Int,
    val eWallet: Int,
    val ib: Int,
    val integrationService: Int,
    val name: String,
    val number: Int,
    val pledges: Int,
    val prbo: Int,
    val referenceData: Int,
    val reports: Int,
    val rko: Int,
    val service: Int,
    val total: Int,
    val treasuryOperations: Int
)