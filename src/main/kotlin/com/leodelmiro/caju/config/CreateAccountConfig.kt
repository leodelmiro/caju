package com.leodelmiro.caju.config

import com.leodelmiro.caju.adapters.out.adapters.CreateAccountAdapter
import com.leodelmiro.caju.application.core.usecase.CreateAccountUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class CreateAccountConfig {
    @Bean
    fun createAccountUseCase(
        createAccountAdapter: CreateAccountAdapter
    ): CreateAccountUseCase {
        return CreateAccountUseCase(createAccountAdapter)
    }
}