package com.leodelmiro.caju.application.ports.`in`

import com.leodelmiro.caju.application.core.domain.Account

interface CreateAccountInputPort {
    fun execute(): Account
}