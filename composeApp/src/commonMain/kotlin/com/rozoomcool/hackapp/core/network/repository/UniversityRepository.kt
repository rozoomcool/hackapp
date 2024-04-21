package com.rozoomcool.hackapp.core.network.repository

import com.rozoomcool.hackapp.core.data.model.University
import com.rozoomcool.hackapp.core.data.request.RegisterRequest
import io.github.aakira.napier.log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class UniversityRepository(
    private val client: HttpClient
) {

    @OptIn(InternalAPI::class)
    suspend fun getUniversities(): List<University> {
        val response = client.get("api/universities/") {
            contentType(ContentType.Application.Json)
        }
        val body = response.bodyAsText()
//        log(tag = "_UNIVERSITYREPOSITORY_") {body}
//        log(tag = "_UNIVERSITYREPOSITORY_") {Json.decodeFromString(ListSerializer(University.serializer()), body).toString()}
        return Json.decodeFromString(ListSerializer(University.serializer()), body)
    }

}