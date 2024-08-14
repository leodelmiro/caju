package com.leodelmiro.caju.adapters.`in`.controller.request

import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.core.domain.Transaction
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class TransactionRequest(
    @NotBlank
    val account: String,

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 19, fraction = 2)
    @NotNull
    val totalAmount: BigDecimal,

    @NotBlank
    @Size(min = 4, max = 4)
    val mcc: String,

    @NotBlank
    @Size(max = 255)
    val merchant: String
) {
    fun toDomain() =
        Transaction(account = Account(id = account.toLong()), totalAmount = totalAmount, mcc = mcc, merchant = merchant)
}