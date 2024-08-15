package com.leodelmiro.caju.application.core.domain

import java.math.BigDecimal
import java.time.LocalDateTime

class Transaction (
    val id: Long? = null,
    var account: Account? = null,
    val totalAmount: BigDecimal = BigDecimal(0),
    var mcc: String,
    val merchant: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)