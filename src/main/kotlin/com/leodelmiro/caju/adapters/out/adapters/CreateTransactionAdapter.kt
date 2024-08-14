package com.leodelmiro.caju.adapters.out.adapters

import com.leodelmiro.caju.adapters.out.repository.SubAccountRepository
import com.leodelmiro.caju.adapters.out.repository.TransactionRepository
import com.leodelmiro.caju.adapters.out.repository.entity.AccountEntity
import com.leodelmiro.caju.adapters.out.repository.entity.SubAccountId
import com.leodelmiro.caju.adapters.out.repository.entity.TransactionEntity
import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.core.domain.Transaction
import com.leodelmiro.caju.application.ports.out.CreateTransactionOutputPort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateTransactionAdapter(
    private val transactionRepository: TransactionRepository,
    private val subAccountRepository: SubAccountRepository
) : CreateTransactionOutputPort {

    @Transactional
    override fun execute(transaction: Transaction, account: Account) =
        transactionRepository.save(TransactionEntity.fromDomain(transaction)).toDomain().also {
            account.subAccounts.forEach {
                subAccountRepository.updateBalance(
                    SubAccountId(AccountEntity.fromDomain(account), it.accountType),
                    it.balance
                )
            }
        }
}