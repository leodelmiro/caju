package com.leodelmiro.caju.application.core.usecase

import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.core.domain.SubAccount
import com.leodelmiro.caju.application.core.domain.Transaction
import com.leodelmiro.caju.application.core.domain.TransactionCode
import com.leodelmiro.caju.application.core.domain.exception.InsufficientBalanceException
import com.leodelmiro.caju.application.ports.`in`.CreateTransactionInputPort
import com.leodelmiro.caju.application.ports.`in`.GetAccountInputPort
import com.leodelmiro.caju.application.ports.out.CreateTransactionOutputPort
import java.math.BigDecimal

class CreateTransactionUseCase(
    private val getAccountInputPort: GetAccountInputPort,
    private val createTransactionOutputPort: CreateTransactionOutputPort
) : CreateTransactionInputPort {


    override fun execute(transaction: Transaction): TransactionCode =
        try {
            val account = getAccount(transaction)
            val subAccountToDebit = getSubAccountByMcc(account, transaction.mcc)

            withdrawAmountFromAccount(subAccountToDebit, transaction.totalAmount)

            createTransactionAndUpdateBalance(transaction, account, subAccountToDebit)

            TransactionCode.APPROVED
        } catch (exception: Exception) {
            when (exception) {
                is InsufficientBalanceException -> TransactionCode.REJECTED
                else -> TransactionCode.ERROR
            }
        }

    private fun getAccount(transaction: Transaction) =
        getAccountInputPort.execute(requireNotNull(transaction.account?.id) { "Account Id cannot be null to create a transaction" })
            .also {
                transaction.account = it
            }

    private fun getSubAccountByMcc(
        account: Account,
        mcc: String
    ) = account.subAccounts.first { it.accountType.mcc.contains(mcc) }


    private fun withdrawAmountFromAccount(
        subAccountToDebit: SubAccount,
        totalAmount: BigDecimal
    ) {
        if (subAccountToDebit.balance < totalAmount) throw InsufficientBalanceException()
        subAccountToDebit.withdraw(totalAmount)
    }

    private fun createTransactionAndUpdateBalance(
        transaction: Transaction,
        account: Account,
        subAccountToDebit: SubAccount
    ) {
        createTransactionOutputPort.execute(transaction, account, subAccountToDebit)
    }

}