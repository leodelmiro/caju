package com.leodelmiro.caju.application.core.usecase

import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.ports.`in`.CreateAccountInputPort
import com.leodelmiro.caju.application.ports.out.CreateAccountOutputPort

class CreateAccountUseCase(private val createAccountOutputPort: CreateAccountOutputPort) : CreateAccountInputPort {
    override fun execute(): Account {
        return createAccountOutputPort.execute(Account())
    }
}