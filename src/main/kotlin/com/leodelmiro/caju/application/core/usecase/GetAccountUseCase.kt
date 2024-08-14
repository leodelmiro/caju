package com.leodelmiro.caju.application.core.usecase

import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.ports.`in`.CreateAccountInputPort
import com.leodelmiro.caju.application.ports.`in`.GetAccountInputPort
import com.leodelmiro.caju.application.ports.out.GetAccountOutputPort

class GetAccountUseCase(private val getAccountOutputPort: GetAccountOutputPort) : GetAccountInputPort {
    override fun execute(accountId: Long): Account {
        return getAccountOutputPort.execute(accountId)
    }
}