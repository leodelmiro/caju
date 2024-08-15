package com.leodelmiro.caju.adapters.`in`.controller.request

import com.leodelmiro.caju.application.core.domain.Merchant
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class MerchantRequest(
    @field:NotBlank
    @field:Size(max = 255)
    val name: String,

    @field:NotBlank
    @field:Size(min = 4, max = 4)
    val mcc: String
) {
    fun toDomain() =
        Merchant(name = name, mcc = mcc)
}