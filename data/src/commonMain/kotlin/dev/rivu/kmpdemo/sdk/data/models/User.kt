package dev.rivu.kmpdemo.sdk.data.models

data class User (
    val name: String,
    val profilePic: String,
    val id: Int,
    val email: String,
    val address: Address,
    val company: Company,
    val userName: String
) {
    
    data class Address(
        val address: String,
        val coordinates: Coordinates,
        val postalCode: String,
    ) {
        
        data class Coordinates(
            val lat: String, // 38.867033
            val lng: String // -76.979235
        )
    }

    data class Company(
        val name: String // Romaguera-Crona
    )
}