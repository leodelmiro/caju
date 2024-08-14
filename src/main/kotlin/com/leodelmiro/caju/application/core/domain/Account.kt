package com.leodelmiro.caju.application.core.domain

import java.time.LocalDateTime

data class Account(
    val id: Long? = null,
    var subAccounts: MutableList<SubAccount> = mutableListOf(),
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    init {
        if (this.subAccounts.isEmpty()) {
            this.subAccounts =
                mutableListOf(
                    SubAccount(this, AccountType.FOOD),
                    SubAccount(this, AccountType.MEAL),
                    SubAccount(this, AccountType.CASH)
                )
        }
    }

    fun getSubAccountByMcc(
        mcc: String
    ) = this.subAccounts.firstOrNull { it.accountType.mcc.contains(mcc) }
        ?: this.subAccounts.first { it.accountType == AccountType.CASH }


    fun getSubAccountCash() = this.subAccounts.first { it.accountType == AccountType.CASH }
}