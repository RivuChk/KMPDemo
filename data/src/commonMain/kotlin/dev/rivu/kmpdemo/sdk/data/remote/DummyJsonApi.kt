package dev.rivu.kmpdemo.sdk.data.remote

import arrow.core.Either
import arrow.core.flatten
import arrow.core.raise.either
import arrow.core.raise.ensure
import dev.rivu.kmpdemo.sdk.data.models.Result
import dev.rivu.kmpdemo.sdk.data.models.DummyJsonUsersResponse
import dev.rivu.kmpdemo.sdk.data.models.JsonPlaceHolderPhotosResponse
import dev.rivu.kmpdemo.sdk.data.remote.di.DummyJsonBaseUrl
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.utils.io.errors.IOException
import me.tatarka.inject.annotations.Inject

@Inject
class DummyJsonApi(
    private val client: HttpClient,
    private val baseUrl: DummyJsonBaseUrl
) {
    suspend fun getUsers(skip: Int, limit: Int = 10): Result<DummyJsonUsersResponse> {
        val result = client.get("$baseUrl/users")
        return Either.catch {
            val status = result.status
            either {
                ensure(!status.isSuccess()) {
                    IOException("Error ${status.description} ${status.value}")
                }
                result.body<DummyJsonUsersResponse>()
            }
        }.flatten()
    }
}