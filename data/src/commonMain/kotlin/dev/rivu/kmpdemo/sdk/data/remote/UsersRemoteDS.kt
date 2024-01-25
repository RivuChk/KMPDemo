package dev.rivu.kmpdemo.sdk.data.remote

import dev.rivu.kmpdemo.sdk.data.models.Page
import dev.rivu.kmpdemo.sdk.data.models.Result
import dev.rivu.kmpdemo.sdk.data.models.User

interface UsersRemoteDS {
    suspend fun getUsersFromJsonPlaceHolder(): Result<List<User>>
    suspend fun getUsersFromDummyJson(pageNo: Int): Result<Page<User>>
}