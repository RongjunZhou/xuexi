package viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.openqa.selenium.firefox.FirefoxDriver
import store.CookieStore


class LoginViewModel: ViewModel() {
    var loginState by mutableStateOf(false)
    private lateinit var driver: FirefoxDriver

    init{
        viewModelScope.launch {
            driver = FirefoxDriver()
            driver.get("https://login.xuexi.cn/login2/?returnUrl=https%3A%2F%2Fstudy.xuexi.cn%2Fadmin%2Findex.html%23%2Freport%2Forganization#/")
        }
    }

    fun login(){
        CookieStore.addCookie(driver.manage().cookies.map { cookie -> cookie.name + "=" + cookie.value })
        loginState = true
    }

}