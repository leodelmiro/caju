package com.leodelmiro.caju.config

import com.leodelmiro.caju.adapters.out.adapters.CreateMerchantAdapter
import com.leodelmiro.caju.application.core.usecase.CreateMerchantUseCase
import com.leodelmiro.caju.application.core.usecase.PolishMerchantNameUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class CreateMerchantConfig {
    @Bean
    fun createMerchantUserCase(
        createMerchantAdapter: CreateMerchantAdapter,
        polishMerchantNameUseCase: PolishMerchantNameUseCase
    ): CreateMerchantUseCase {
        return CreateMerchantUseCase(createMerchantAdapter, polishMerchantNameUseCase)
    }
}