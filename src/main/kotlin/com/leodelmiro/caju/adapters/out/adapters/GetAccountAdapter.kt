package com.leodelmiro.caju.adapters.out.adapters

import com.leodelmiro.caju.adapters.out.repository.AccountRepository
import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.ports.out.GetAccountOutputPort
import org.springframework.stereotype.Component

@Component
class GetAccountAdapter(private val accountRepository: AccountRepository) : GetAccountOutputPort {
    override fun execute(accountId: Long): Account {
        return accountRepository.findById(accountId).orElseThrow().toDomain()
    }
}