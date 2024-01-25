package dev.rivu.kmpdemo.sdk.data

import dev.rivu.kmpdemo.sdk.data.models.ApiType
import dev.rivu.kmpdemo.sdk.data.models.DummyJsonUsersResponse.User
import dev.rivu.kmpdemo.sdk.data.models.Page

interface UsersRepository {
    suspend fun getUsers(apiType: ApiType, pageNo: Int): Page<User>
}