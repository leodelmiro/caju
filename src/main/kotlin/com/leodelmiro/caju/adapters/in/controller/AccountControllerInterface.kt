package com.leodelmiro.caju.adapters.`in`.controller

import com.leodelmiro.caju.adapters.`in`.controller.response.AccountResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Account", description = "Endpoints relacionados ao Account")
interface AccountControllerInterface {

    @Operation(summary = "Cria Conta", description = "Realiza uma criação de um novo Account")
    @ApiResponses(value = [ApiResponse(responseCode = "201", description = "Conta cadastrada")])
    fun create(): ResponseEntity<AccountResponse>
}