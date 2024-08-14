package com.leodelmiro.caju.adapters.out.repository.entity

import com.leodelmiro.caju.application.core.domain.Transaction
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_transaction")
class TransactionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    val account: AccountEntity? = null,

    val totalAmount: BigDecimal = BigDecimal(0),

    val mcc: String? = null,

    val merchant: String? = null,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Transaction(
        id = this.id,
        account = this.account?.toDomain(),
        totalAmount = this.totalAmount,
        mcc = this.mcc.toString(),
        merchant = this.merchant.toString(),
        createdAt = this.createdAt
    )

    companion object {
        fun fromDomain(transaction: Transaction): TransactionEntity {
            return TransactionEntity(
                id = transaction.id,
                account = AccountEntity.fromDomain(requireNotNull(transaction.account)),
                totalAmount = transaction.totalAmount,
                mcc = transaction.mcc,
                merchant = transaction.merchant,
                createdAt = transaction.createdAt
            )
        }
    }
}