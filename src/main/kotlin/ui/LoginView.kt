package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import util.QRCodeUtil
import viewModel.LoginViewModel

@Composable
@Preview
fun LoginView(viewModel: LoginViewModel) {

    MaterialTheme {
        Image(
            bitmap = QRCodeUtil.encode(viewModel.qrInfo, 800, 800),
            contentDescription = "QR Code"
        )
    }

}