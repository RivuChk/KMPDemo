package dev.rivu.kmpdemo.sdk.data.remote

import arrow.core.Either
import arrow.core.flatten
import arrow.core.raise.either
import arrow.core.raise.ensure
import dev.rivu.kmpdemo.sdk.data.models.JsonPlaceHolderPhotosResponse
import dev.rivu.kmpdemo.sdk.data.models.Result
import dev.rivu.kmpdemo.sdk.data.models.JsonPlaceholdersUsersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.utils.io.errors.IOException

class JsonPlaceholderApi(
    private val client: HttpClient,
    private val baseUrl: String
) {
    suspend fun getUsers(): Result<JsonPlaceholdersUsersResponse> {
        val result = client.get("$baseUrl/users")
        return Either.catch {
            val status = result.status
            either {
                ensure(!status.isSuccess()) {
                    IOException("Error ${status.description} ${status.value}")
                }
                result.body<JsonPlaceholdersUsersResponse>()
            }
        }.flatten()
    }

    suspend fun getPhotoUrl(userId: Int): Result<String> {
        val result = client.get("$baseUrl/users/$userId/photos")
        return Either.catch {
            val status = result.status
            either {
                ensure(!status.isSuccess()) {
                    IOException("Error ${status.description} ${status.value}")
                }
                result.body<JsonPlaceHolderPhotosResponse>().first().thumbnailUrl
            }
        }.flatten()
    }
}