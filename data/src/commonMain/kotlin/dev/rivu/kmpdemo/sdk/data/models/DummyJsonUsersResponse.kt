package dev.rivu.kmpdemo.sdk.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyJsonUsersResponse(
    @SerialName("limit")
    val limit: Int, // 30
    @SerialName("skip")
    val skip: Int, // 0
    @SerialName("total")
    val total: Int, // 100
    @SerialName("users")
    val users: List<User>
) {
    @Serializable
    data class User(
        @SerialName("address")
        val address: Address,
        @SerialName("company")
        val company: Company,
        @SerialName("email")
        val email: String, // atuny0@sohu.com
        @SerialName("firstName")
        val firstName: String, // Terry
        @SerialName("gender")
        val gender: String, // male
        @SerialName("id")
        val id: Int, // 1
        @SerialName("image")
        val image: String, // https://robohash.org/Terry.png?set=set4
        @SerialName("lastName")
        val lastName: String, // Medhurst
        @SerialName("phone")
        val phone: String, // +63 791 675 8914
        @SerialName("username")
        val username: String, // atuny0
    ) {
        @Serializable
        data class Address(
            @SerialName("address")
            val address: String, // 1745 T Street Southeast
            @SerialName("city")
            val city: String, // Washington
            @SerialName("coordinates")
            val coordinates: Coordinates,
            @SerialName("postalCode")
            val postalCode: String, // 20020
            @SerialName("state")
            val state: String // DC
        ) {
            @Serializable
            data class Coordinates(
                @SerialName("lat")
                val lat: String, // 38.867033
                @SerialName("lng")
                val lng: String // -76.979235
            )
        }

        @Serializable
        data class Company(
            @SerialName("address")
            val address: Address,
            @SerialName("department")
            val department: String, // Marketing
            @SerialName("name")
            val name: String, // Blanda-O'Keefe
            @SerialName("title")
            val title: String // Help Desk Operator
        )

    }
}