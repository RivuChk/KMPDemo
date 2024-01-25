package dev.rivu.kmpdemo.sdk.data.repository.di

import dev.rivu.kmpdemo.sdk.data.remote.UsersRemoteDS
import dev.rivu.kmpdemo.sdk.data.remote.UsersRemoteDSImpl
import dev.rivu.kmpdemo.sdk.data.remote.di.RemoteComponent
import dev.rivu.kmpdemo.sdk.data.repository.UsersRepository
import dev.rivu.kmpdemo.sdk.data.repository.UsersRepositoryImpl
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class RepositoryComponent(
    @Component val remoteComponent: RemoteComponent
) {
    @Provides
    fun providesUsersRepository(): UsersRepository = UsersRepositoryImpl(
        remoteComponent.usersRemoteDS
    )
}