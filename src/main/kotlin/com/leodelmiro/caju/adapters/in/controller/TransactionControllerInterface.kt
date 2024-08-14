package com.leodelmiro.caju.adapters.`in`.controller

import com.leodelmiro.caju.adapters.`in`.controller.request.TransactionRequest
import com.leodelmiro.caju.adapters.`in`.controller.response.TransactionResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Transaction", description = "Endpoints relacionados a Transação")
interface TransactionControllerInterface {

    @Operation(summary = "Cria transação", description = "Realiza uma transação")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Transação retornada")])
    fun create(transactionRequest: TransactionRequest): ResponseEntity<TransactionResponse>
}
