package com.leodelmiro.caju.adapters.`in`.controller.response

import com.leodelmiro.caju.application.core.domain.Account
import java.time.LocalDateTime


data class AccountResponse(
    val id: Long? = null,
    var subAccounts: List<SubAccountResponse> = listOf(),
    val createdAt: LocalDateTime
) {
    companion object {
        fun fromDomain(account: Account) = AccountResponse(
            id = account.id,
            subAccounts = account.subAccounts.map { SubAccountResponse.fromDomain(it) },
            createdAt = account.createdAt
        )
    }
}