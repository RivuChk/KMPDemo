package dev.rivu.kmpdemo.sdk

import dev.rivu.kmpdemo.sdk.data.remote.di.DummyJsonBaseUrl
import dev.rivu.kmpdemo.sdk.data.remote.di.JsonPlaceHolderBaseUrl
import dev.rivu.kmpdemo.sdk.data.remote.di.RemoteComponent
import dev.rivu.kmpdemo.sdk.data.repository.UsersRepository
import dev.rivu.kmpdemo.sdk.data.repository.di.RepositoryComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
internal abstract class DataLayerComponent(
    @Component val remoteComponent: RemoteComponent,
    @Component val repositoryComponent: RepositoryComponent,
) {
    abstract val repository: UsersRepository
}

expect object DataLayer {
    fun getUsersRepo(
        jsonPlaceholderBaseURl: String,
        dummyJsonBaseURl: String
    ): UsersRepository
}