package com.leodelmiro.caju.adapters.`in`.controller

import com.leodelmiro.caju.adapters.`in`.controller.request.MerchantRequest
import com.leodelmiro.caju.adapters.`in`.controller.response.MerchantResponse
import com.leodelmiro.caju.application.ports.`in`.CreateMerchantInputPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping("/api/v1/merchants")
class MerchantController(private val createMerchantInputPort: CreateMerchantInputPort) : MerchantControllerInterface {

    // Fake controller to add merchant
    @PostMapping
    override fun register(@Valid @RequestBody merchantRequest: MerchantRequest): ResponseEntity<MerchantResponse> {
        val response =
            createMerchantInputPort.execute(merchantRequest.toDomain()).let { MerchantResponse.fromDomain(it) }
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(response.id).toUri()
        return ResponseEntity.created(uri).body(response)
    }
}