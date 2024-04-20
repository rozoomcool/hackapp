package com.rozoomcool.hackapp.core.network.service

interface AuthService {

    suspend fun signIn(): String
}