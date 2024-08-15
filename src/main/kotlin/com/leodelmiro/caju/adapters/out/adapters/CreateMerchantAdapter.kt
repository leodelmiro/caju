package com.leodelmiro.caju.adapters.out.adapters

import com.leodelmiro.caju.adapters.out.repository.MerchantRepository
import com.leodelmiro.caju.adapters.out.repository.entity.MerchantEntity
import com.leodelmiro.caju.application.core.domain.Merchant
import com.leodelmiro.caju.application.ports.out.CreateMerchantOutputPort
import org.springframework.stereotype.Component

@Component
class CreateMerchantAdapter(private val merchantRepository: MerchantRepository) : CreateMerchantOutputPort {
    override fun execute(merchant: Merchant): Merchant {
        return merchantRepository.save(MerchantEntity.fromDomain(merchant)).toDomain()
    }
}