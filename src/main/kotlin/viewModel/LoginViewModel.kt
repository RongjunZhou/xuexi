package viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.openqa.selenium.firefox.FirefoxDriver
import service.LoginService

class LoginViewModel: ViewModel() {
    var loginState by mutableStateOf(false)
    var qrInfo by mutableStateOf("")

    init{
        viewModelScope.launch {
            while(!loginState){
                val driver = FirefoxDriver()
                driver.get("https://login.xuexi.cn/login2/?returnUrl=https%3A%2F%2Fstudy.xuexi.cn%2Fadmin%2Findex.html%23%2Freport%2Forganization#/")
                println(driver.title)
                driver.sessionStorage
                qrInfo = LoginService.generateQR()
                println(qrInfo)
                delay(1000 * 60)
            }
        }
        viewModelScope.launch {
            while(!loginState){
                loginState = LoginService.checkLogin(qrInfo)
                println(loginState)
                delay(1000 * 3)
            }
        }
    }
}