package dev.rivu.kmpdemo.sdk.data.remote.di

import dev.rivu.kmpdemo.sdk.data.remote.DummyJsonApi
import dev.rivu.kmpdemo.sdk.data.remote.JsonPlaceholderApi
import dev.rivu.kmpdemo.sdk.data.remote.UsersRemoteDS
import dev.rivu.kmpdemo.sdk.data.remote.UsersRemoteDSImpl
import dev.rivu.kmpdemo.sdk.network.KtorClient
import io.ktor.client.HttpClient
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class RemoteComponent(
    @get:Provides val jsonPlaceholderBaseURl: JsonPlaceHolderBaseUrl,
    @get:Provides val dummyJsonBaseURl: DummyJsonBaseUrl,
) {
    abstract val usersRemoteDS: UsersRemoteDSImpl

    @Provides
    fun providesHttpClient(): HttpClient = KtorClient
}

typealias JsonPlaceHolderBaseUrl = String
typealias DummyJsonBaseUrl = String