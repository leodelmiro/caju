package com.leodelmiro.caju.adapters.out.repository.entity

import com.leodelmiro.caju.application.core.domain.Account
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_account")
data class AccountEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToMany(mappedBy = "id.account", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var subAccounts: List<SubAccountEntity> = listOf(),
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun toDomain() = Account(
        id = this.id,
        subAccounts = this.subAccounts.map { it.toDomain() }.toMutableList(),
        createdAt = this.createdAt
    )

    companion object {
        fun fromDomain(account: Account): AccountEntity {
            val accountEntity = AccountEntity(
                id = account.id,
                subAccounts = listOf(),
                createdAt = account.createdAt
            )
            accountEntity.subAccounts = account.subAccounts.map { SubAccountEntity.fromDomain(it, accountEntity) }
            return accountEntity
        }
    }
}