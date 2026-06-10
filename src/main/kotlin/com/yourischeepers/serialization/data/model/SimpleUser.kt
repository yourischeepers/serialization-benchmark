package com.yourischeepers.serialization.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SimpleUser(
    val id: Int,
    val username: String,
    val age: Int,
    val active: Boolean,
)
