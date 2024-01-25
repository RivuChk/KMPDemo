package dev.rivu.kmpdemo.sdk.data.models

import arrow.core.Either

typealias Result<T> = Either<Throwable, T>