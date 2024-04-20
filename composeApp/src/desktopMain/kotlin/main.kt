import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rozoomcool.hackapp.com.rozoomcool.hackapp.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "hackapp") {
        App()
    }
}