package com.rozoomcool.hackapp.core.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.rozoomcool.hackapp.R
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Composable
internal actual fun __NetworkImage(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale,
    contentDescription: String?
) {
//    SubcomposeAsyncImage(
//        model = imageUrl,
//        loading = {
//            Box(contentAlignment = Alignment.Center) {
//                CircularProgressIndicator(
//                    color = colorScheme.secondary,
//                    modifier = Modifier.size(32.dp)
//                )
//            }
//        },
//        imageLoader = provideImageLoader(LocalContext.current),
//        contentDescription = contentDescription,
//        contentScale = contentScale,
//        modifier = modifier
//    )
//    PicassoImage(imageUrl, LocalContext.current)
//    LoadImageFromUnsecuredSource(imageUrl, provideImageLoader(LocalContext.current))

    AsyncImage(
        model = imageUrl,
        modifier = modifier,
        contentScale = contentScale,
        contentDescription = contentDescription
    )
}

fun providePicassoWithUnsafeOkHttpClient(context: Context): Picasso {
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
        override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf()
    })

    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, java.security.SecureRandom())
    val sslSocketFactory = sslContext.socketFactory

    val okHttpClient = OkHttpClient.Builder()
        .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        .hostnameVerifier(HostnameVerifier { _, _ -> true })
        .build()

    return Picasso.Builder(context)
        .downloader(OkHttp3Downloader(okHttpClient))
        .build()
}

fun loadImage(imageView: ImageView, imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .into(imageView)
}

@Composable
fun LoadImageFromUnsecuredSource(url: String, imageLoader: ImageLoader) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(url)
            .crossfade(true)
            .build(),
        imageLoader = provideImageLoader(context),
        contentDescription = "Remote Image"
    )
}

fun createUnsafeOkHttpClient(): OkHttpClient {
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        @SuppressLint("TrustAllX509TrustManager")
        override fun checkClientTrusted(chain: Array<out java.security.cert.X509Certificate>?, authType: String?) {
            // Здесь нет необходимости в реализации, так как мы доверяем всем сертификатам
        }

        @SuppressLint("TrustAllX509TrustManager")
        override fun checkServerTrusted(chain: Array<out java.security.cert.X509Certificate>?, authType: String?) {
            // Здесь нет необходимости в реализации, так как мы доверяем всем сертификатам
        }

        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
            // Возвращаем пустой массив вместо null
            return arrayOf()
        }
    })

    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, java.security.SecureRandom())

    return OkHttpClient.Builder()
        .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0] as X509TrustManager)
        .hostnameVerifier(HostnameVerifier { _, _ -> true })
        .build()
}

fun provideImageLoader(context: Context): ImageLoader {
    return ImageLoader.Builder(context)
        .okHttpClient(createUnsafeOkHttpClient())
        .build()
}