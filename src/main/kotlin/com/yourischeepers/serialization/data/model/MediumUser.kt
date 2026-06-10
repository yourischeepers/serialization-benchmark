package com.yourischeepers.serialization.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MediumUser(
    val id: Int,
    val username: String,
    val email: String,
    val age: Int,
    val active: Boolean,
    val address: Address,
    val preferences: Preferences,
)

@Serializable
data class Address(
    val street: String,
    val city: String,
    val postalCode: String,
    val country: String,
)

@Serializable
data class Preferences(
    val language: String,
    val darkMode: Boolean,
    val emailNotifications: Boolean,
)
