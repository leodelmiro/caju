package com.leodelmiro.caju.adapters.out.adapters

import com.leodelmiro.caju.adapters.out.repository.AccountRepository
import com.leodelmiro.caju.adapters.out.repository.entity.AccountEntity
import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.ports.out.CreateAccountOutputPort
import org.springframework.stereotype.Component

@Component
class CreateAccountAdapter(private val accountRepository: AccountRepository) : CreateAccountOutputPort {
    override fun execute(account: Account): Account {
        return accountRepository.save(AccountEntity.fromDomain(account)).toDomain()
    }
}