package com.rozoomcool.hackapp.di

import com.rozoomcool.hackapp.core.network.ktorHttpClient
import com.rozoomcool.hackapp.core.network.repository.UserRepository
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val networkModule = module{
    single(qualifier(NetworkQualifiers.BaseUrl)) { "http://localhost:8000" }
    single {
        ktorHttpClient(
            baseUrl = get(
                qualifier = qualifier(
                    NetworkQualifiers.BaseUrl
                )
            )
        )
    }
    single{UserRepository(get())}
}