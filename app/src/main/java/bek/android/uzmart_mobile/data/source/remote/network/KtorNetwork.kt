package bek.android.uzmart_mobile.data.source.remote.network

import bek.android.uzmart_mobile.domain.datasource.cache.Settings
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType

class KtorNetwork constructor(private val setting: Settings) {

    fun getClient(): HttpClient = HttpClient(Android) {
        defaultRequest {
            contentType(ContentType.Application.Json)
            val token = setting.getToken()
            if (!token.isNullOrBlank()) {
                header("Authorization", "Bearer $token")
            }
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 60_000
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
}