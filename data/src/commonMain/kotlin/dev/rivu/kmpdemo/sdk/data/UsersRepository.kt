package dev.rivu.kmpdemo.sdk.data

import dev.rivu.kmpdemo.sdk.data.models.ApiType
import dev.rivu.kmpdemo.sdk.data.models.User
import dev.rivu.kmpdemo.sdk.data.models.Page
import dev.rivu.kmpdemo.sdk.data.models.Result

interface UsersRepository {
    suspend fun getUsers(apiType: ApiType, pageNo: Int): Result<Page<User>>
}