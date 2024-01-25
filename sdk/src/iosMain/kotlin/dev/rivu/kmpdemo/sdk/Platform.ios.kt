package dev.rivu.kmpdemo.sdk

import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
actual fun isDebug(): Boolean = Platform.isDebugBinary