package com.rozoomcool.hackapp.core.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import io.github.aakira.napier.log
import org.koin.compose.koinInject

@Composable
internal expect fun __NetworkImage(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale,
    contentDescription: String?,
)

@Composable
internal fun NetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale,
    contentDescription: String? = null,
) {
    val baseUrl = koinInject<String>()
    val imgUrl = "$baseUrl/media/$imageUrl"
    log(tag = ":::::::::") { imgUrl }
    __NetworkImage(
        imageUrl = imgUrl,
        modifier = modifier,
        contentScale = contentScale,
        contentDescription = contentDescription
    )
}