package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import viewModel.LoginViewModel

@Composable
@Preview
fun LoginView(viewModel: LoginViewModel) {

    MaterialTheme {

        Row(
            modifier = Modifier.padding(20.dp,20.dp,20.dp,20.dp).fillMaxSize()
        ) {
            Button(
                onClick = {
                    viewModel.login()
                },
            ){
                Text(if(!viewModel.loginState)"我已登录" else "重新加载")
            }
        }
    }

}