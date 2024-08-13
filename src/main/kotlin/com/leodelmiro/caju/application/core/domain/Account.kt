package com.leodelmiro.caju.application.core.domain

data class Account(
    val id: Long? = null,
    var subAccounts: MutableList<SubAccount> = mutableListOf()
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
}