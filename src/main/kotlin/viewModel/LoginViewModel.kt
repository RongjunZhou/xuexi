package viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import moe.tlaster.precompose.viewmodel.ViewModel

class LoginViewModel: ViewModel() {

    val loginState by mutableStateOf(true)
}