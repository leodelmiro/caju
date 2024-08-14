package com.leodelmiro.caju.adapters.out.repository

import com.leodelmiro.caju.adapters.out.repository.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<TransactionEntity, Long> {
}