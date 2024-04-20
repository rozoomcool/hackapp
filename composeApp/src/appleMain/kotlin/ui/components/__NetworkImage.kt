package ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

@Composable
internal expect fun __NetworkImage(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale,
    contentDescription: String?
)