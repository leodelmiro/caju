package com.leodelmiro.caju.adapters.out.repository.entity

import com.leodelmiro.caju.application.core.domain.Account
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_account")
data class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToMany(mappedBy = "id.account", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var subAccounts: List<SubAccountEntity> = listOf(),
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun toDomain() = Account(id = this.id, )

    companion object {
        fun fromDomain(account: Account): AccountEntity {
            val accountEntity = AccountEntity(
                id = account.id,
                subAccounts = listOf()
            )
            accountEntity.subAccounts = account.subAccounts.map { SubAccountEntity.fromDomain(it, accountEntity) }
            return accountEntity
        }
    }
}