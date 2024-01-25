package dev.rivu.kmpdemo.sdk.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias JsonPlaceholdersUsersResponse  = List<JsonPlaceholdersUsersResponseItem>

@Serializable
data class JsonPlaceholdersUsersResponseItem(
    @SerialName("address")
    val address: Address,
    @SerialName("company")
    val company: Company,
    @SerialName("email")
    val email: String, // Sincere@april.biz
    @SerialName("id")
    val id: Int, // 1
    @SerialName("name")
    val name: String, // Leanne Graham
    @SerialName("phone")
    val phone: String, // 1-770-736-8031 x56442
    @SerialName("username")
    val username: String, // Bret
    @SerialName("website")
    val website: String // hildegard.org
) {
    @Serializable
    data class Address(
        @SerialName("city")
        val city: String, // Gwenborough
        @SerialName("geo")
        val geo: Geo,
        @SerialName("street")
        val street: String, // Kulas Light
        @SerialName("suite")
        val suite: String, // Apt. 556
        @SerialName("zipcode")
        val zipcode: String // 92998-3874
    ) {
        @Serializable
        data class Geo(
            @SerialName("lat")
            val lat: String, // -37.3159
            @SerialName("lng")
            val lng: String // 81.1496
        )
    }

    @Serializable
    data class Company(
        @SerialName("name")
        val name: String // Romaguera-Crona
    )
}