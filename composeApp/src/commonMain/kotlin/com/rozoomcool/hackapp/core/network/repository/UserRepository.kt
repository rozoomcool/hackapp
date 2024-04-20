package com.rozoomcool.hackapp.core.network.repository

import com.rozoomcool.hackapp.core.data.request.RegisterRequest
import io.github.aakira.napier.Napier
import io.github.aakira.napier.log
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.runBlocking

class UserRepository(
    private val client: HttpClient
) {
    suspend fun register(registerRequest: RegisterRequest) = runBlocking {
        val response = client.post("/api/register/") {
            contentType(ContentType.Application.Json)
            setBody(registerRequest)
        }
        log ( tag = ":gfdg" ) { ":::: ${response.toString()}" }
    }
}