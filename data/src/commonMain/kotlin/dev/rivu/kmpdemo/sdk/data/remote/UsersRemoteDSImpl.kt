package dev.rivu.kmpdemo.sdk.data.remote

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.flatten
import arrow.core.raise.either
import dev.rivu.kmpdemo.sdk.data.mappers.mapToUsersList
import dev.rivu.kmpdemo.sdk.data.mappers.mapToUsersPage
import dev.rivu.kmpdemo.sdk.data.models.JsonPlaceholdersUsersResponseItem
import dev.rivu.kmpdemo.sdk.data.models.Page
import dev.rivu.kmpdemo.sdk.data.models.Result
import dev.rivu.kmpdemo.sdk.data.models.User

class UsersRemoteDSImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val dummyJsonApi: DummyJsonApi,
) : UsersRemoteDS {
    override suspend fun getUsersFromJsonPlaceHolder(): Result<List<User>> {
        return Either.catch {
            val response = jsonPlaceholderApi.getUsers()

            val profilePics = response.flatMap {

                either {
                    it.map {
                        jsonPlaceholderApi.getPhotoUrl(it.id)
                    }.bindAll()
                }

            }

            either {
                createUser(response.bind(), profilePics.bind())
            }
        }.flatten()

    }

    private fun createUser(usersList: List<JsonPlaceholdersUsersResponseItem>, profilePicsList: List<String>): List<User> {
        return usersList.mapToUsersList(profilePicsList)
    }

    override suspend fun getUsersFromDummyJson(pageNo: Int): Result<Page<User>> {
        val limit: Int = 10
        return Either.catch {
            dummyJsonApi.getUsers(skip = pageNo * limit).map {
                it.mapToUsersPage()
            }
        }.flatten()
    }
}