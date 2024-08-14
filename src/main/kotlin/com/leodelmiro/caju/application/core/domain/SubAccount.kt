package com.leodelmiro.caju.application.core.domain

import java.math.BigDecimal

data class SubAccount(
    val account: Account? = null,
    val accountType: AccountType,
    var balance: BigDecimal = BigDecimal(0)
) {
    fun withdrawAndReturnRemainder(amount: BigDecimal): BigDecimal {
        var remainder = amount
        if (this.balance > remainder) {
            this.balance -= remainder
            return BigDecimal.ZERO
        }
        remainder -= this.balance.also { this.balance = BigDecimal.ZERO }
        return remainder
    }

    fun isCash() = this.accountType == AccountType.CASH
}