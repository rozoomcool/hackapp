package com.rozoomcool.hackapp.core.network.repository

import com.rozoomcool.hackapp.core.data.request.AuthRequest
import com.rozoomcool.hackapp.core.data.request.RegisterRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import kotlinx.serialization.json.Json

class UserRepository(
    private val client: HttpClient
) {
    @OptIn(InternalAPI::class)
    suspend fun signUp(registerRequest: RegisterRequest): HttpResponse {
        val response = client.post("api/register/") {
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(RegisterRequest.serializer(), registerRequest)
        }

        return response
    }

    @OptIn(InternalAPI::class)
    suspend fun signIp(authRequest: AuthRequest): HttpResponse {
        val response = client.post("api/token/") {
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(AuthRequest.serializer(), authRequest)
        }

        return response
    }
}