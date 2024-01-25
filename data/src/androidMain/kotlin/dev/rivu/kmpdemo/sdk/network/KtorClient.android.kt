package dev.rivu.kmpdemo.sdk.network

import android.util.Log
import dev.rivu.kmpdemo.sdk.network.json
import dev.rivu.kmpdemo.sdk.network.retryConfig
import dev.rivu.kmpdemo.sdk.isDebug
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import okhttp3.logging.HttpLoggingInterceptor

actual val KtorClient: HttpClient by lazy {
    Log.d("SDK","KtorClient Android")

    HttpClient(OkHttp) {
        // default validation to throw exceptions for non-2xx responses
        expectSuccess = true

        engine {
            // add logging interceptor
            if (isDebug()) {
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(
                            HttpLoggingInterceptor.Level.BODY,
                        )
                    },
                )
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