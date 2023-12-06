import androidx.compose.runtime.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow
import ui.LoginView


fun main() = application {
    val loginState by remember { mutableStateOf(true) }
    PreComposeWindow(
        onCloseRequest = ::exitApplication,
        visible = loginState,
        resizable = false,
        title = "请使用学习强国客户端扫码登录",
        state = WindowState(size = DpSize(400.dp,430.dp)),
    ) {
        LoginView()
    }

}
