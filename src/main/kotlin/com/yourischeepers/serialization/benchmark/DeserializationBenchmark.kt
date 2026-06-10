package com.yourischeepers.serialization.benchmark

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yourischeepers.serialization.data.generators.RandomComplexUserGenerator
import com.yourischeepers.serialization.data.generators.RandomMediumUserGenerator
import com.yourischeepers.serialization.data.generators.RandomSimpleUserGenerator
import com.yourischeepers.serialization.data.model.ComplexUser
import com.yourischeepers.serialization.data.model.MediumUser
import com.yourischeepers.serialization.data.model.SimpleUser
import kotlinx.benchmark.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

@State(Scope.Benchmark)
class DeserializationBenchmark {

    @Param("100", "1000", "10000")
    var size: Int = 0

    @Param("simple", "medium", "complex")
    lateinit var complexity: String

    private lateinit var jsonString: String

    private val gson = Gson()

    private val kotlinxJson = Json {
        ignoreUnknownKeys = false
        encodeDefaults = true
    }

    private val simpleUserListType = object : TypeToken<List<SimpleUser>>() {}.type
    private val mediumUserListType = object : TypeToken<List<MediumUser>>() {}.type
    private val complexUserListType = object : TypeToken<List<ComplexUser>>() {}.type

    @Setup
    fun setup() {
        jsonString = when (complexity) {
            "simple" -> RandomSimpleUserGenerator().getRandom(size)
            "medium" -> RandomMediumUserGenerator().getRandom(size)
            "complex" -> RandomComplexUserGenerator().getRandom(size)
            else -> error("Unknown complexity: $complexity")
        }
    }

    @Benchmark
    fun gsonDeserialize(): Int {
        val result = when (complexity) {
            "simple" -> gson.fromJson<List<SimpleUser>>(jsonString, simpleUserListType)
            "medium" -> gson.fromJson<List<MediumUser>>(jsonString, mediumUserListType)
            "complex" -> gson.fromJson<List<ComplexUser>>(jsonString, complexUserListType)
            else -> error("Unknown complexity: $complexity")
        }

        return result.size
    }

    @Benchmark
    fun kotlinxDeserialize(): Int {
        val result = when (complexity) {
            "simple" -> kotlinxJson.decodeFromString(
                ListSerializer(SimpleUser.serializer()),
                jsonString
            )

            "medium" -> kotlinxJson.decodeFromString(
                ListSerializer(MediumUser.serializer()),
                jsonString
            )

            "complex" -> kotlinxJson.decodeFromString(
                ListSerializer(ComplexUser.serializer()),
                jsonString
            )

            else -> error("Unknown complexity: $complexity")
        }

        return result.size
    }
}
