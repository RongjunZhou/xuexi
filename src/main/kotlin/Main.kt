import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import util.QRCodeUtil

@Composable
@Preview
fun App() {

    MaterialTheme {
        val qrInfo: String by remember { mutableStateOf("") }
        Image(
            bitmap = QRCodeUtil.encode("https://qr.xuexi.cn/action/oa_login?code=qr:A2B26992-915D-426B-9EA9-5C2DC255E6F4", 800, 800),
            contentDescription = "QR Code"
        )
    }

}

fun main() = application {
    val loginState by remember { mutableStateOf(true) }
    Window(
        onCloseRequest = ::exitApplication,
        visible = loginState,
        resizable = false,
        title = "请使用学习强国客户端扫码登录",
        state = WindowState(size = DpSize(400.dp,430.dp)),
    ) {
        App()
    }
}
