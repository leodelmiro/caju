package com.leodelmiro.caju.application.core.usecase

import com.leodelmiro.caju.application.ports.`in`.PolishMerchantNameInputPort

class PolishMerchantNameUseCase() : PolishMerchantNameInputPort {
    override fun execute(name: String): String {
        // Here we are only removing extra spaces, but it could also, separate location and name
        return removeExtraSpaces(name)
    }

    private fun removeExtraSpaces(name: String) = name.trim().replace("\\s+".toRegex(), " ")
}