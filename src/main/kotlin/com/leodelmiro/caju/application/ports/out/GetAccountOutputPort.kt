package com.leodelmiro.caju.application.ports.out

import com.leodelmiro.caju.application.core.domain.Account

interface GetAccountOutputPort {
    fun execute(accountId: Long): Account
}