package com.leodelmiro.caju.application.core.domain

import java.math.BigDecimal

data class SubAccount(
    val account: Account? = null,
    val accountType: AccountType,
    var balance: BigDecimal = BigDecimal(0)
) {
    fun withdraw(amount: BigDecimal) {
        this.balance -= amount
    }
}