package com.yourischeepers.serialization.data.generators

import com.yourischeepers.serialization.Constants

object RandomPrimitiveGenerator {

    fun getRandomString(length: Int): String {
        return String(CharArray(length) { Constants.AllowedChars.random(Constants.Random) })
    }

    fun getRandomBoolean(): Boolean {
        return Constants.Random.nextBoolean()
    }

    fun getRandomInt(): Int {
        return Constants.Random.nextInt()
    }

    fun getRandomDouble(): Double {
        return Constants.Random.nextDouble()
    }

    fun getRandomLong(): Long {
        return Constants.Random.nextLong()
    }
}
