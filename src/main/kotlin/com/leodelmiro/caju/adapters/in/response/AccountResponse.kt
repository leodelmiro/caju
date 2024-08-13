package com.leodelmiro.caju.adapters.`in`.response

import com.leodelmiro.caju.application.core.domain.Account


data class AccountResponse(
    val id: Long? = null,
    var subAccounts: List<SubAccountResponse> = listOf()
) {
    companion object {
        fun fromDomain(account: Account) = AccountResponse(
            id = account.id,
            subAccounts = account.subAccounts.map { SubAccountResponse.fromDomain(it) })
    }
}