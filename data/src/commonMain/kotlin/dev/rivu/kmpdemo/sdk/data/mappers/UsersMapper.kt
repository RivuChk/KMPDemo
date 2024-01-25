package dev.rivu.kmpdemo.sdk.data.mappers

import dev.rivu.kmpdemo.sdk.data.models.DummyJsonUsersResponse
import dev.rivu.kmpdemo.sdk.data.models.JsonPlaceholdersUsersResponse
import dev.rivu.kmpdemo.sdk.data.models.Page
import dev.rivu.kmpdemo.sdk.data.models.User
import dev.rivu.kmpdemo.sdk.data.models.User.Address
import dev.rivu.kmpdemo.sdk.data.models.User.Address.Coordinates
import dev.rivu.kmpdemo.sdk.data.models.User.Company

fun JsonPlaceholdersUsersResponse.mapToUsersList(profilePicsList: List<String>): List<User> {
    return zip(profilePicsList) { responseItem, profilePicItem ->
        User(
            id = responseItem.id,
            name = responseItem.name,
            email = responseItem.email,
            profilePic = profilePicItem,
            userName = responseItem.username,
            address = Address(
                address = responseItem.address.street,
                postalCode = responseItem.address.zipcode,
                coordinates = Coordinates(
                    lat = responseItem.address.geo.lat,
                    lng = responseItem.address.geo.lng,
                )
            ),
            company = Company(
                name = responseItem.company.name
            )
        )
    }
}

fun DummyJsonUsersResponse.mapToUsersPage(): Page<User> {
    return Page(
        pageNo = (total - skip) / limit,
        pageSize = users.size,
        nextPageAvailable = total > (limit + skip),
        items = users.map { responseItem->
            User(
                id = responseItem.id,
                name = responseItem.firstName + " " + responseItem.lastName,
                email = responseItem.email,
                profilePic = responseItem.image,
                userName = responseItem.username,
                address = Address(
                    address = responseItem.address.address,
                    postalCode = responseItem.address.postalCode,
                    coordinates = Coordinates(
                        lat = responseItem.address.coordinates.lat,
                        lng = responseItem.address.coordinates.lng,
                    )
                ),
                company = Company(
                    name = responseItem.company.name
                )
            )
        }
    )
}