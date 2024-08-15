package com.leodelmiro.caju.application.ports.`in`

import com.leodelmiro.caju.application.core.domain.Merchant

interface CreateMerchantInputPort {
    fun execute(merchant: Merchant): Merchant
}