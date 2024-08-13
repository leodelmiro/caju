package com.leodelmiro.caju.adapters.out.repository.entity

import com.leodelmiro.caju.application.core.domain.SubAccount
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_sub_account")
data class SubAccountEntity(
    @EmbeddedId
    val id: SubAccountId,
    val balance: BigDecimal = BigDecimal(0),
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun toDomain() = SubAccount(
        account = this.id.account?.toDomain(),
        accountType = this.id.accountType,
        balance = this.balance
    )

    companion object {
        fun fromDomain(subAccount: SubAccount, accountEntity: AccountEntity): SubAccountEntity {
            return SubAccountEntity(
                id = SubAccountId(
                    account = accountEntity,
                    accountType = subAccount.accountType
                ),
                balance = subAccount.balance
            )
        }
    }
}