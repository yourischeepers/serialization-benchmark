package com.yourischeepers.serialization.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ComplexUser(
    val id: Int,
    val username: String,
    val email: String,
    val age: Int,
    val active: Boolean,
    val profile: Profile,
    val orders: List<Order>,
    val devices: List<Device>,
    val metadata: UserMetadata,
)

@Serializable
data class Profile(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: Address,
    val preferences: Preferences,
)

@Serializable
data class Order(
    val orderId: Int,
    val totalPrice: Double,
    val currency: String,
    val items: List<OrderItem>,
)

@Serializable
data class OrderItem(
    val productId: Int,
    val productName: String,
    val quantity: Int,
    val price: Double,
)

@Serializable
data class Device(
    val deviceId: String,
    val platform: String,
    val appVersion: String,
    val lastLoginTimestamp: Long,
)

@Serializable
data class UserMetadata(
    val createdAt: Long,
    val updatedAt: Long,
    val source: String,
    val tags: List<String>,
)
