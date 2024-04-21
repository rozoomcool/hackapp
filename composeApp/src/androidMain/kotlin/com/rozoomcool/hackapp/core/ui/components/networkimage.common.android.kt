package com.rozoomcool.hackapp.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage

@Composable
internal actual fun __NetworkImage(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale,
    contentDescription: String?
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        loading = {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    color = colorScheme.secondary,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
    AsyncImage(
        model = imageUrl,
        modifier = modifier,
        contentScale = contentScale,
        contentDescription = contentDescription
    )
}