package com.rozoomcool.hackapp.core.ui.components

import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import android.view.Choreographer
import android.view.MotionEvent
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.viewinterop.AndroidView
import com.rozoomcool.hackapp.R
import org.rajawali3d.cameras.ArcballCamera
import org.rajawali3d.materials.Material
import org.rajawali3d.materials.textures.ATexture
import org.rajawali3d.materials.textures.Texture
import org.rajawali3d.math.vector.Vector3
import org.rajawali3d.primitives.Sphere
import org.rajawali3d.renderer.Renderer
import org.rajawali3d.view.SurfaceView
import java.io.IOException

class PanoramaRenderer(context: Context, val view: SurfaceView) : Renderer(context) {
    init {
        setFrameRate(60.0)
    }

    override fun onOffsetsChanged(
        xOffset: Float,
        yOffset: Float,
        xOffsetStep: Float,
        yOffsetStep: Float,
        xPixelOffset: Int,
        yPixelOffset: Int
    ) {

    }

    override fun onTouchEvent(event: MotionEvent?) {

    }

    override fun initScene() {
        val sphere = Sphere(2f, 64, 32)
        sphere.isDoubleSided = true
        sphere.rotate(Vector3.Axis.Y, 180.0) // Поворот, чтобы начать с правильного угла просмотра

        // Создание и настройка материала
        val material = Material()
        material.colorInfluence = 0f  // Убедитесь, что цвет текстуры не изменяется цветом материала
        try {
            val texture = Texture("PanoramaTexture", R.drawable.maxresdefault)
            material.addTexture(texture)
        } catch (e: ATexture.TextureException) {
            e.printStackTrace()
        }

        sphere.material = material
        currentScene.addChild(sphere)

        // Инициализация камеры с передачей SurfaceView
        var currentCamera = ArcballCamera(context, view)
        currentCamera.setPosition(0.0, 0.0, 0.0)
    }

    override fun onRender(ellapsedRealtime: Long, deltaTime: Double) {
        super.onRender(ellapsedRealtime, deltaTime)
    }
}

@Composable
fun PanoramaView(context: Context) {
    AndroidView(
        factory = { ctx ->
            SurfaceView(ctx).also {
                it.setSurfaceRenderer(PanoramaRenderer(ctx, it))
            }
        },
        update = { }
    )
}

@Composable
actual fun __Panorama(imageName: String?) {
    PanoramaView(LocalContext.current)
}