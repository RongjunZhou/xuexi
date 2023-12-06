package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import service.LoginService
import util.QRCodeUtil

@Composable
@Preview
fun LoginView() {

    MaterialTheme {
        Image(
            bitmap = QRCodeUtil.encode(LoginService.generateQR(), 800, 800),
            contentDescription = "QR Code"
        )
    }

}