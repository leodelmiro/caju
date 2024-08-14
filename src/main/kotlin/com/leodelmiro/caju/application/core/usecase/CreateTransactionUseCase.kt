package com.leodelmiro.caju.application.core.usecase

import com.leodelmiro.caju.application.core.domain.*
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

            withdrawAmountFromAccount(account, transaction.mcc, transaction.totalAmount)

            createTransactionAndUpdateBalance(transaction, account)

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


    private fun withdrawAmountFromAccount(
        account: Account,
        mcc: String,
        totalAmount: BigDecimal
    ) {
        val subAccountToDebit = account.getSubAccountByMcc(mcc)
        var amount = subAccountToDebit.withdrawAndReturnRemainder(totalAmount)

        if (isAmountBiggerThanZero(amount)) {
            if (subAccountToDebit.isCash()) throw InsufficientBalanceException()

            account.getSubAccountCash().let {
                amount = it.withdrawAndReturnRemainder(amount)
                if (isAmountBiggerThanZero(amount)) throw InsufficientBalanceException()
                it.withdrawAndReturnRemainder(amount)
                return
            }
        }
    }

    private fun isAmountBiggerThanZero(amount: BigDecimal) = amount > BigDecimal.ZERO

    private fun createTransactionAndUpdateBalance(
        transaction: Transaction,
        account: Account,
    ) {
        createTransactionOutputPort.execute(transaction, account)
    }

}