package com.yourischeepers.serialization.data.generators

import com.yourischeepers.serialization.Constants.AppVersionLength
import com.yourischeepers.serialization.Constants.CurrencyLength
import com.yourischeepers.serialization.Constants.DeviceAmount
import com.yourischeepers.serialization.Constants.DeviceIdLength
import com.yourischeepers.serialization.Constants.EmailLength
import com.yourischeepers.serialization.Constants.FirstNameLength
import com.yourischeepers.serialization.Constants.LastNameLength
import com.yourischeepers.serialization.Constants.OrderAmount
import com.yourischeepers.serialization.Constants.OrderItemAmount
import com.yourischeepers.serialization.Constants.PhoneNumberLength
import com.yourischeepers.serialization.Constants.PlatformLength
import com.yourischeepers.serialization.Constants.ProductNameLength
import com.yourischeepers.serialization.Constants.SourceLength
import com.yourischeepers.serialization.Constants.TagAmount
import com.yourischeepers.serialization.Constants.TagLength
import com.yourischeepers.serialization.Constants.UsernameLength
import com.yourischeepers.serialization.data.model.*
import kotlinx.serialization.json.Json

class RandomComplexUserGenerator {

    private val mediumUserGenerator = RandomMediumUserGenerator()

    fun getRandom(amount: Int): String {
        val users = List(amount) { getRandom() }
        return Json.encodeToString(users)
    }

    private fun getRandom(): ComplexUser {
        return ComplexUser(
            id = RandomPrimitiveGenerator.getRandomInt(),
            username = RandomPrimitiveGenerator.getRandomString(UsernameLength),
            age = RandomPrimitiveGenerator.getRandomInt(),
            active = RandomPrimitiveGenerator.getRandomBoolean(),
            email = RandomPrimitiveGenerator.getRandomString(EmailLength),
            profile = getRandomProfile(),
            orders = List(OrderAmount) { getRandomOrder() },
            devices = List(DeviceAmount) { getRandomDevice() },
            metadata = getRandomUserMetadata(),
        )
    }

    private fun getRandomProfile(): Profile {
        return Profile(
            firstName = RandomPrimitiveGenerator.getRandomString(FirstNameLength),
            lastName = RandomPrimitiveGenerator.getRandomString(LastNameLength),
            phoneNumber = RandomPrimitiveGenerator.getRandomString(PhoneNumberLength),
            address = mediumUserGenerator.getRandomAddress(),
            preferences = mediumUserGenerator.getRandomPreferences(),
        )
    }

    private fun getRandomOrder(): Order {
        return Order(
            orderId = RandomPrimitiveGenerator.getRandomInt(),
            totalPrice = RandomPrimitiveGenerator.getRandomDouble(),
            currency = RandomPrimitiveGenerator.getRandomString(CurrencyLength),
            items = List(OrderItemAmount) { getRandomOrderItem() },
        )
    }

    private fun getRandomOrderItem(): OrderItem {
        return OrderItem(
            productId = RandomPrimitiveGenerator.getRandomInt(),
            productName = RandomPrimitiveGenerator.getRandomString(ProductNameLength),
            quantity = RandomPrimitiveGenerator.getRandomInt(),
            price = RandomPrimitiveGenerator.getRandomDouble(),
        )
    }

    private fun getRandomDevice(): Device {
        return Device(
            deviceId = RandomPrimitiveGenerator.getRandomString(DeviceIdLength),
            platform = RandomPrimitiveGenerator.getRandomString(PlatformLength),
            appVersion = RandomPrimitiveGenerator.getRandomString(AppVersionLength),
            lastLoginTimestamp = RandomPrimitiveGenerator.getRandomLong(),
        )
    }

    private fun getRandomUserMetadata(): UserMetadata {
        return UserMetadata(
            createdAt = RandomPrimitiveGenerator.getRandomLong(),
            updatedAt = RandomPrimitiveGenerator.getRandomLong(),
            source = RandomPrimitiveGenerator.getRandomString(SourceLength),
            tags = List(TagAmount) { RandomPrimitiveGenerator.getRandomString(TagLength) },
        )
    }
}
