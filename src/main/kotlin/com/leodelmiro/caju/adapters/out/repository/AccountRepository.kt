package com.leodelmiro.caju.adapters.out.repository

import com.leodelmiro.caju.adapters.out.repository.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, Long> {
}