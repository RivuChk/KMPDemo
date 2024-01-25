package dev.rivu.kmpdemo.sdk.network

import dev.rivu.kmpdemo.sdk.network.json
import dev.rivu.kmpdemo.sdk.isDebug
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.LogLevel.BODY
import io.ktor.client.plugins.logging.Logging

actual val KtorClient: HttpClient by lazy {
    HttpClient() {
        install(ContentNegotiation) {
            json
        }

        if (isDebug()) {
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}