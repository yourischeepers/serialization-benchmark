package com.yourischeepers.serialization.data.generators

import com.yourischeepers.serialization.Constants.UsernameLength
import com.yourischeepers.serialization.data.model.SimpleUser
import kotlinx.serialization.json.Json

class RandomSimpleUserGenerator {

    fun getRandom(amount: Int): String {
        val users = List(amount) { getRandom() }
        return Json.encodeToString(users)
    }

    private fun getRandom(): SimpleUser {
        return SimpleUser(
            id = RandomPrimitiveGenerator.getRandomInt(),
            username = RandomPrimitiveGenerator.getRandomString(UsernameLength),
            age = RandomPrimitiveGenerator.getRandomInt(),
            active = RandomPrimitiveGenerator.getRandomBoolean(),
        )
    }
}
