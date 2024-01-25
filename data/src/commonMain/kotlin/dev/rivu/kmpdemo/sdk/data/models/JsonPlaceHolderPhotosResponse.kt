package dev.rivu.kmpdemo.sdk.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias JsonPlaceHolderPhotosResponse = List<JsonPlaceHolderPhotosResponseItem>

@Serializable
data class JsonPlaceHolderPhotosResponseItem(
    @SerialName("albumId")
    val albumId: Int, // 1
    @SerialName("id")
    val id: Int, // 1
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String, // https://via.placeholder.com/150/92c952
    @SerialName("title")
    val title: String, // accusamus beatae ad facilis cum similique qui sunt
    @SerialName("url")
    val url: String // https://via.placeholder.com/600/92c952
)