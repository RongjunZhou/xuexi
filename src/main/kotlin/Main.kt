
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow
import moe.tlaster.precompose.ui.viewModel
import ui.LoginView
import viewModel.LoginViewModel


fun main() = application {

    PreComposeWindow(
        onCloseRequest = ::exitApplication,
        resizable = false,
        title = "请使用学习强国客户端扫码登录",
        state = WindowState(size = DpSize(400.dp,430.dp)),
    ) {
        val loginViewModel = viewModel { LoginViewModel() }
        LoginView(loginViewModel)
        this.window.isVisible = !loginViewModel.loginState
    }

}
