package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Panorama(
    val id: Long,
    val panorama: String
)
