package com.leodelmiro.caju.adapters.`in`.response

import com.leodelmiro.caju.application.core.domain.AccountType
import com.leodelmiro.caju.application.core.domain.SubAccount
import java.math.BigDecimal

data class SubAccountResponse(
    val accountType: AccountType,
    val balance: BigDecimal = BigDecimal(0)
) {
    companion object {
        fun fromDomain(subAccount: SubAccount) =
            SubAccountResponse(accountType = subAccount.accountType, balance = subAccount.balance)
    }
}