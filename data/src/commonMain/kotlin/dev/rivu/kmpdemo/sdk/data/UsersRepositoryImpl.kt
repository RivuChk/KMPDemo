package dev.rivu.kmpdemo.sdk.data

import dev.rivu.kmpdemo.sdk.data.models.ApiType
import dev.rivu.kmpdemo.sdk.data.models.ApiType.DummyJson
import dev.rivu.kmpdemo.sdk.data.models.ApiType.JsonPlaceholder
import dev.rivu.kmpdemo.sdk.data.models.Page
import dev.rivu.kmpdemo.sdk.data.models.Result
import dev.rivu.kmpdemo.sdk.data.models.User
import dev.rivu.kmpdemo.sdk.data.remote.UsersRemoteDS

class UsersRepositoryImpl(
    private val remoteDS: UsersRemoteDS
) : UsersRepository {
    override suspend fun getUsers(apiType: ApiType, pageNo: Int): Result<Page<User>> {
        return when(apiType) {
            DummyJson -> remoteDS.getUsersFromDummyJson(pageNo)
            JsonPlaceholder -> remoteDS.getUsersFromJsonPlaceHolder().map {
                Page(
                    pageNo = 0,
                    pageSize = it.size,
                    nextPageAvailable = false,
                    items = it
                )
            }
        }
    }
}