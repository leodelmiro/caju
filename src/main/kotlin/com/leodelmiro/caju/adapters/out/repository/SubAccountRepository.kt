package com.leodelmiro.caju.adapters.out.repository

import com.leodelmiro.caju.adapters.out.repository.entity.SubAccountEntity
import com.leodelmiro.caju.adapters.out.repository.entity.SubAccountId
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.math.BigDecimal

interface SubAccountRepository : JpaRepository<SubAccountEntity, SubAccountId> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE SubAccountEntity sa SET sa.balance = :balance WHERE sa.id = :id")
    fun updateBalance(id: SubAccountId, balance: BigDecimal)
}