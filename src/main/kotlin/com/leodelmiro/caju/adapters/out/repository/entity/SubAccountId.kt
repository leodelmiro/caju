package com.leodelmiro.caju.adapters.out.repository.entity

import com.leodelmiro.caju.application.core.domain.AccountType
import jakarta.persistence.*
import java.io.Serializable

@Embeddable
data class SubAccountId(
    @ManyToOne
    @JoinColumn(name = "account_id")
    val account: AccountEntity? = null,

    @Enumerated(EnumType.STRING)
    val accountType: AccountType? = null
) : Serializable