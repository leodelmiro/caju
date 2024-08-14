package com.leodelmiro.caju.config

import com.leodelmiro.caju.adapters.out.adapters.CreateTransactionAdapter
import com.leodelmiro.caju.application.core.usecase.CreateTransactionUseCase
import com.leodelmiro.caju.application.core.usecase.GetAccountUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class CreateTransactionConfig {
    @Bean
    fun createTransactionUseCase(
        getAccountUseCase: GetAccountUseCase,
        createTransactionAdapter: CreateTransactionAdapter
    ): CreateTransactionUseCase {
        return CreateTransactionUseCase(
            getAccountUseCase,
            createTransactionAdapter
        )
    }
}