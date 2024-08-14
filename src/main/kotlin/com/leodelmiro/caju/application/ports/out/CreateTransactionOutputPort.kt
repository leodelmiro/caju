package com.leodelmiro.caju.application.ports.out

import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.core.domain.SubAccount
import com.leodelmiro.caju.application.core.domain.Transaction

interface CreateTransactionOutputPort {
    fun execute(transaction: Transaction, account: Account, subAccount: SubAccount): Transaction
}