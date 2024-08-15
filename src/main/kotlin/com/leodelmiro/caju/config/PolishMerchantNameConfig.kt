package com.leodelmiro.caju.config

import com.leodelmiro.caju.application.core.usecase.PolishMerchantNameUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class PolishMerchantNameConfig {
    @Bean
    fun polishMerchantNameUseCase(): PolishMerchantNameUseCase {
        return PolishMerchantNameUseCase()
    }
}