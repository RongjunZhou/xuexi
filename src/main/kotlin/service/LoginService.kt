package service

import androidx.compose.runtime.MutableState
import api.LoginApi
import config.RetrofitConfig
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginService {

    private val loginApi = RetrofitConfig.getRetrofit("https://login.xuexi.cn", LoginApi::class.java)
    fun generateQR(): String = "https://qr.xuexi.cn/action/oa_login?code=" + loginApi.generateQRCode().execute().body()?.result
}