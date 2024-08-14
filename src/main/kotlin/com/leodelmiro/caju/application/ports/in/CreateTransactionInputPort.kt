package com.leodelmiro.caju.application.ports.`in`

import com.leodelmiro.caju.application.core.domain.Transaction
import com.leodelmiro.caju.application.core.domain.TransactionCode

interface CreateTransactionInputPort {
    fun execute(transaction: Transaction): TransactionCode
}