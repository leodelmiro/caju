package com.leodelmiro.caju.adapters.out.adapters

import com.leodelmiro.caju.adapters.out.repository.MerchantRepository
import com.leodelmiro.caju.application.core.domain.Merchant
import com.leodelmiro.caju.application.ports.out.GetMerchantMccByNameOutputPort
import org.springframework.stereotype.Component

@Component
class GetMerchantMccByNameAdapter(private val merchantRepository: MerchantRepository) : GetMerchantMccByNameOutputPort {

    override fun execute(name: String): Merchant? =
        merchantRepository.findMerchantByName(name)?.toDomain()
}