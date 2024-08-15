package com.leodelmiro.caju.application.core.usecase

import com.leodelmiro.caju.application.core.domain.Merchant
import com.leodelmiro.caju.application.ports.`in`.CreateMerchantInputPort
import com.leodelmiro.caju.application.ports.`in`.PolishMerchantNameInputPort
import com.leodelmiro.caju.application.ports.out.CreateMerchantOutputPort

class CreateMerchantUseCase(
    private val createMerchantOutputPort: CreateMerchantOutputPort,
    private val polishMerchantNameInputPort: PolishMerchantNameInputPort
) : CreateMerchantInputPort {
    override fun execute(merchant: Merchant): Merchant {
        merchant.name = polishMerchantNameInputPort.execute(merchant.name)
        return createMerchantOutputPort.execute(merchant)
    }
}