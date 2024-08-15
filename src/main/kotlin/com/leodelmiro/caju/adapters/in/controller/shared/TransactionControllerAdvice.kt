package com.leodelmiro.caju.adapters.`in`.controller.shared

import com.leodelmiro.caju.adapters.`in`.controller.TransactionController
import com.leodelmiro.caju.adapters.`in`.controller.response.TransactionResponse
import com.leodelmiro.caju.application.core.domain.TransactionCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(assignableTypes = [TransactionController::class])
class TransactionControllerAdvice {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: Exception): ResponseEntity<TransactionResponse> =
        ResponseEntity(TransactionResponse(TransactionCode.ERROR.code), HttpStatus.OK)

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<TransactionResponse> =
        ResponseEntity(TransactionResponse(TransactionCode.ERROR.code), HttpStatus.OK)


    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<TransactionResponse> =
        ResponseEntity(TransactionResponse(TransactionCode.ERROR.code), HttpStatus.OK)
}