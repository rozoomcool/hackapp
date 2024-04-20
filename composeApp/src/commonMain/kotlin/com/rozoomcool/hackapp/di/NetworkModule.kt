package com.rozoomcool.hackapp.di

import com.rozoomcool.hackapp.core.network.ktorHttpClient
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val networkModule = module{
    single(qualifier(NetworkQualifiers.BaseUrl)) { "https://api-picture.onrender.com" }
    single(qualifier(NetworkQualifiers.Client)) {
        ktorHttpClient(
            baseUrl = get(
                qualifier = qualifier(
                    NetworkQualifiers.BaseUrl
                )
            )
        )
    }
}