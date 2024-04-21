package com.rozoomcool.hackapp.di

import com.rozoomcool.hackapp.core.network.ktorHttpClient
import com.rozoomcool.hackapp.core.network.repository.UniversityRepository
import com.rozoomcool.hackapp.core.network.repository.UserRepository
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val networkModule = module{
    single<String> { "http://localhost" }
    single {
        ktorHttpClient(
//            baseUrl = get(
//                qualifier = qualifier(
//                    NetworkQualifiers.BaseUrl
//                )
//            )
            baseUrl = "http://192.168.1.113/"
        )
    }
    single{UserRepository(get())}
    single{UniversityRepository(get())}
}