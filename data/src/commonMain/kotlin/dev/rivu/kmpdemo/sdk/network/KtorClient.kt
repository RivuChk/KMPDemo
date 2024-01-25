package dev.rivu.kmpdemo.sdk.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.plugins.HttpRequestRetry.Configuration
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation.Config
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation.Plugin
import kotlinx.serialization.json.Json

expect val KtorClient: HttpClient


val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
}

fun Configuration.retryConfig() {
    retryOnServerErrors(maxRetries = 3)
    exponentialDelay()
}