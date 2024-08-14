package com.leodelmiro.caju.adapters.`in`.controller.request

import com.leodelmiro.caju.application.core.domain.Account
import com.leodelmiro.caju.application.core.domain.Transaction
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class TransactionRequest(
    @field:NotBlank
    val account: String,

    @field:DecimalMin(value = "0.0", inclusive = false)
    @field:Digits(integer = 19, fraction = 2)
    @field:NotNull
    val totalAmount: BigDecimal,

    @field:NotBlank
    val mcc: String,

    @field:NotBlank
    @field:Size(max = 255)
    val merchant: String
) {
    fun toDomain() =
        Transaction(account = Account(id = account.toLong()), totalAmount = totalAmount, mcc = mcc, merchant = merchant)
}