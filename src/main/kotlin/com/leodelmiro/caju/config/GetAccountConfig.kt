package com.leodelmiro.caju.config

import com.leodelmiro.caju.adapters.out.adapters.GetAccountAdapter
import com.leodelmiro.caju.application.core.usecase.GetAccountUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GetAccountConfig {
    @Bean
    fun getAccountUseCase(
        getAccountAdapter: GetAccountAdapter
    ): GetAccountUseCase {
        return GetAccountUseCase(getAccountAdapter)
    }
}