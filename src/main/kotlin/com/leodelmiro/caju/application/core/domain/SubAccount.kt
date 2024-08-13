package com.leodelmiro.caju.application.core.domain

import java.math.BigDecimal

data class SubAccount(
    val account: Account?,
    val accountType: AccountType,
    val balance: BigDecimal = BigDecimal(0)
)