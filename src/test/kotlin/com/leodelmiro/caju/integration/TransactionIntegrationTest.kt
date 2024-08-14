package com.leodelmiro.caju.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.leodelmiro.caju.adapters.`in`.controller.request.TransactionRequest
import com.leodelmiro.caju.adapters.`in`.controller.response.TransactionResponse
import com.leodelmiro.caju.application.core.domain.TransactionCode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TransactionIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @ParameterizedTest
    @ValueSource(strings = ["5411","5412","5811","5812"])
    fun `should return code 00 and create transaction when available balance` (mcc: String) {
        val transactionRequest = TransactionRequest(
            account = "1",
            totalAmount = BigDecimal(100.00),
            mcc = mcc,
            merchant = "PADARIA DO ZE               SAO PAULO BR"
        )

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transactionRequest))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        val response = objectMapper.readValue(result.response.contentAsString, TransactionResponse::class.java)
        assertEquals(TransactionCode.APPROVED.code, response.code)
    }

    @Test
    fun `should return code 51 when unavailable balance`() {
        val transactionRequest = TransactionRequest(
            account = "2",
            totalAmount = BigDecimal(1),
            mcc = "5811",
            merchant = "PADARIA DO ZE               SAO PAULO BR"
        )

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transactionRequest))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        val response = objectMapper.readValue(result.response.contentAsString, TransactionResponse::class.java)
        assertEquals(TransactionCode.REJECTED.code, response.code)
    }

    @Test
    fun `should return code 07 when account not found balance`() {
        val transactionRequest = TransactionRequest(
            account = "99999",
            totalAmount = BigDecimal(1),
            mcc = "5811",
            merchant = "PADARIA DO ZE               SAO PAULO BR"
        )

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transactionRequest))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        val response = objectMapper.readValue(result.response.contentAsString, TransactionResponse::class.java)
        assertEquals(TransactionCode.ERROR.code, response.code)
    }

    @Test
    fun `should return code 07 when any field validation error`() {
        val transactionRequest = TransactionRequest(
            account = "1",
            totalAmount = BigDecimal(1),
            mcc = "58111",
            merchant = "PADARIA DO ZE               SAO PAULO BR"
        )

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("/api/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transactionRequest))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

        val response = objectMapper.readValue(result.response.contentAsString, TransactionResponse::class.java)
        assertEquals(TransactionCode.ERROR.code, response.code)
    }
}