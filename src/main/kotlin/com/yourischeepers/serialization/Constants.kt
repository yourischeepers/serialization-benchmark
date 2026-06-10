package com.yourischeepers.serialization

import kotlin.random.Random

object Constants {

    val AllowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')

    const val Seed = 2003
    val Random = Random(seed = Seed)

    const val UsernameLength = 20

    const val EmailLength = 50
    const val StreetLength = 30
    const val CityLength = 20
    const val PostalCodeLength = 6
    const val CountryLength = 15
    const val LanguageLength = 5

    const val FirstNameLength = 10
    const val LastNameLength = 20
    const val PhoneNumberLength = 20
    const val CurrencyLength = 3
    const val ProductNameLength = 40
    const val DeviceIdLength = 20
    const val PlatformLength = 20
    const val AppVersionLength = 5
    const val SourceLength = 16
    const val TagLength = 15

    const val OrderAmount = 10
    const val OrderItemAmount = 7
    const val DeviceAmount = 5
    const val TagAmount = 6
}
