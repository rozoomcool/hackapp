package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class University(
    val id: Long,
    val faculties: List<Faculty>? = null,
//    val posts: List<Post>,
    val panoramas: List<Panorama>,
    val name: String,
    val location: String?,
    val description: String,
    val avatar: String,
)