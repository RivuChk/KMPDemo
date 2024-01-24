package dev.rivu.kmpdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform