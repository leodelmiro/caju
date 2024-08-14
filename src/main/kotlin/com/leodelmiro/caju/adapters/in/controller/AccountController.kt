package com.leodelmiro.caju.adapters.`in`.controller

import com.leodelmiro.caju.adapters.`in`.controller.response.AccountResponse
import com.leodelmiro.caju.application.ports.`in`.CreateAccountInputPort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping("/api/v1/accounts")
class AccountController(private val createAccountInputPort: CreateAccountInputPort) {

    // Fake Controller Just to create a simple Account
    @PostMapping
    fun create(): ResponseEntity<AccountResponse> {
        val response = createAccountInputPort.execute().let { AccountResponse.fromDomain(it) }
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(response.id).toUri()
        return ResponseEntity.created(uri).body(response)
    }
}