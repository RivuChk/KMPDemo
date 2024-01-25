package dev.rivu.kmpdemo.sdk

import dev.rivu.kmpdemo.sdk.data.remote.di.RemoteComponent
import dev.rivu.kmpdemo.sdk.data.remote.di.create
import dev.rivu.kmpdemo.sdk.data.repository.UsersRepository
import dev.rivu.kmpdemo.sdk.data.repository.di.RepositoryComponent
import dev.rivu.kmpdemo.sdk.data.repository.di.create

actual object DataLayer{
    actual fun getUsersRepo(jsonPlaceholderBaseURl: String, dummyJsonBaseURl: String): UsersRepository {
        val remoteComponent = RemoteComponent::class.create(
            jsonPlaceholderBaseURl = jsonPlaceholderBaseURl,
            dummyJsonBaseURl = dummyJsonBaseURl
        )
        return DataLayerComponent::class.create(
            remoteComponent,
            RepositoryComponent::class.create(remoteComponent)
        ).repository
    }
}