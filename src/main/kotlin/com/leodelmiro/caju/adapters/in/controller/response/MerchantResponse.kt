package com.leodelmiro.caju.adapters.`in`.controller.response

import com.leodelmiro.caju.application.core.domain.Merchant
import java.time.LocalDateTime

data class MerchantResponse(
    val id: Long? = null,
    val name: String,
    val mcc: String,
    val createdAt: LocalDateTime
) {
    companion object {
        fun fromDomain(merchant: Merchant) = MerchantResponse(
            id = merchant.id,
            name = merchant.name,
            mcc = merchant.mcc,
            createdAt = merchant.createdAt
        )
    }
}