package com.leodelmiro.caju.application.core.domain

enum class TransactionCode(val code: String) {
    APPROVED("00"),
    REJECTED("51"),
    ERROR("07");
}