package dev.rivu.kmpdemo.sdk.data.models

data class Page<T>(
    val pageNo: Int,
    val pageSize: Int,
    val nextPageAvailable: Boolean,
    val items: List<T>
)
