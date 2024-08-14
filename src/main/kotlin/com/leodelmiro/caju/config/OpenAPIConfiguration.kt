package com.leodelmiro.caju.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfiguration {
    private val devUrl = "localhost:8080"

    @Bean
    fun myOpenAPI(): OpenAPI {
        val devServer: Server = Server()
        devServer.url = devUrl
        devServer.description = "Server URL para ambiente de Dev"

        val contact: Contact = Contact()
        contact.email = "leodelmiroms@gmail.com"
        contact.name = "Leonardo Delmiro"
        contact.url = "https://github.com/leodelmiro"

        val mitLicense: License = License().name("MIT License").url("https://choosealicense.com/licenses/mit/")

        val info: Info = Info()
            .title("Caju - Backend Teste")
            .version("1.0")
            .contact(contact)
            .description("A API expõe endpoints para o desafio Caju.")
            .license(mitLicense)

        return OpenAPI().info(info).servers(listOf(devServer))
    }
}