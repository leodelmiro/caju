package com.leodelmiro.caju.application.ports.out

import com.leodelmiro.caju.application.core.domain.Merchant

interface CreateMerchantOutputPort {
    fun execute(merchant: Merchant): Merchant
}