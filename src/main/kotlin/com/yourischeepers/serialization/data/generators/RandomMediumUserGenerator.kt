package com.yourischeepers.serialization.data.generators

import com.yourischeepers.serialization.Constants.CityLength
import com.yourischeepers.serialization.Constants.CountryLength
import com.yourischeepers.serialization.Constants.EmailLength
import com.yourischeepers.serialization.Constants.LanguageLength
import com.yourischeepers.serialization.Constants.PostalCodeLength
import com.yourischeepers.serialization.Constants.StreetLength
import com.yourischeepers.serialization.Constants.UsernameLength
import com.yourischeepers.serialization.data.model.Address
import com.yourischeepers.serialization.data.model.MediumUser
import com.yourischeepers.serialization.data.model.Preferences
import kotlinx.serialization.json.Json

class RandomMediumUserGenerator {

    fun getRandom(amount: Int): String {
        val users = List(amount) { getRandom() }
        return Json.encodeToString(users)
    }

    private fun getRandom(): MediumUser {
        return MediumUser(
            id = RandomPrimitiveGenerator.getRandomInt(),
            username = RandomPrimitiveGenerator.getRandomString(UsernameLength),
            age = RandomPrimitiveGenerator.getRandomInt(),
            active = RandomPrimitiveGenerator.getRandomBoolean(),
            email = RandomPrimitiveGenerator.getRandomString(EmailLength),
            address = getRandomAddress(),
            preferences = getRandomPreferences(),
        )
    }

    fun getRandomAddress(): Address {
        return Address(
            street = RandomPrimitiveGenerator.getRandomString(StreetLength),
            city = RandomPrimitiveGenerator.getRandomString(CityLength),
            postalCode = RandomPrimitiveGenerator.getRandomString(PostalCodeLength),
            country = RandomPrimitiveGenerator.getRandomString(CountryLength),
        )
    }

    fun getRandomPreferences(): Preferences {
        return Preferences(
            language = RandomPrimitiveGenerator.getRandomString(LanguageLength),
            darkMode = RandomPrimitiveGenerator.getRandomBoolean(),
            emailNotifications = RandomPrimitiveGenerator.getRandomBoolean(),
        )
    }
}
