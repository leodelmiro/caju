package com.leodelmiro.caju.adapters.`in`.controller

import com.leodelmiro.caju.adapters.`in`.controller.request.MerchantRequest
import com.leodelmiro.caju.adapters.`in`.controller.response.MerchantResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Merchant", description = "Endpoints relacionados ao Comércio (Estabelecimento)")
interface MerchantControllerInterface {

    @Operation(summary = "Registra comércio", description = "Realiza um registro de comércio")
    @ApiResponses(value = [ApiResponse(responseCode = "201", description = "Transação retornada")])
    fun register(merchantRequest: MerchantRequest): ResponseEntity<MerchantResponse>
}
