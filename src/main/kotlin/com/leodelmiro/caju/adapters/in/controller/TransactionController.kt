package com.leodelmiro.caju.adapters.`in`.controller

import com.leodelmiro.caju.adapters.`in`.controller.request.TransactionRequest
import com.leodelmiro.caju.adapters.`in`.controller.response.TransactionResponse
import com.leodelmiro.caju.application.ports.`in`.CreateTransactionInputPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(private val createTransactionInputPort: CreateTransactionInputPort) {

    @PostMapping
    fun create(@Valid @RequestBody transactionRequest: TransactionRequest): ResponseEntity<TransactionResponse> =
        TransactionResponse(createTransactionInputPort.execute(transactionRequest.toDomain()).code).let {
            ResponseEntity.ok().body(it)
        }
}