package com.leodelmiro.caju.adapters.out.repository.entity

import com.leodelmiro.caju.application.core.domain.Merchant
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_merchant")
data class MerchantEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String? = null,
    val mcc: String? = null,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Merchant(
        id = this.id,
        name = requireNotNull(this.name),
        mcc = requireNotNull(this.mcc),
        createdAt = this.createdAt
    )

    companion object {
        fun fromDomain(merchant: Merchant): MerchantEntity {
            return MerchantEntity(
                id = merchant.id,
                name = merchant.name,
                mcc = merchant.mcc,
                createdAt = merchant.createdAt
            )
        }
    }
}