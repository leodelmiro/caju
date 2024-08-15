package com.leodelmiro.caju.application.core.domain

import java.time.LocalDateTime

data class Merchant(
    val id: Long? = null,
    var name: String,
    val mcc: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)