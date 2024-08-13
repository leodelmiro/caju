package com.leodelmiro.caju.application.ports.out

import com.leodelmiro.caju.application.core.domain.Account

interface CreateAccountOutputPort {
    fun execute(account: Account): Account
}