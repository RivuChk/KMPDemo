package dev.rivu.kmpdemo.sdk.network

import dev.rivu.kmpdemo.sdk.isDebug
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging

actual val KtorClient: HttpClient by lazy {
    HttpClient(Darwin) {
        // default validation to throw exceptions for non-2xx responses
        expectSuccess = true

        if (isDebug()) {
            install(Logging) {
                level = LogLevel.ALL
            }
        }

        engine {
            configureRequest {
                setAllowsCellularAccess(true)
                setAllowsExpensiveNetworkAccess(true)
            }
        }

        install(ContentNegotiation) {
            json
        }

        install(HttpRequestRetry) {
            retryConfig()
        }
    }
}