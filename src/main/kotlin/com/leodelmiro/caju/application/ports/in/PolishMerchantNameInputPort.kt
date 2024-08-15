package com.leodelmiro.caju.application.ports.`in`

interface PolishMerchantNameInputPort {
    fun execute(name: String): String
}