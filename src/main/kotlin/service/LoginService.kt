package service

import androidx.compose.runtime.MutableState
import api.LoginApi
import config.RetrofitConfig
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginService {

    val loginApi = RetrofitConfig.retrofit.baseUrl("https://login.xuexi.cn").build().create(LoginApi::class.java)
    suspend fun generateQR(qrInfo: MutableState<String>){
        coroutineScope {
            qrInfo.value = loginApi.generateQRCode()["result"].asString
            delay(30000)
        }
    }
}