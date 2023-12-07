package service

import api.LoginApi
import config.RetrofitConfig
import okhttp3.MultipartBody

object LoginService {
    private val loginApi = RetrofitConfig.getRetrofit("https://login.xuexi.cn", LoginApi::class.java)
    fun generateQR(): String = "https://qr.xuexi.cn/action/oa_login?code=" + loginApi.generateQRCode().execute().body()?.result
    fun checkLogin(qrCode: String): Boolean {
        val body = loginApi.checkLogin(
            MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("qrCode", qrCode)
                .addFormDataPart("goto", "https://partyoa.xuexi.cn")
                .addFormDataPart("pdmToken", "")
                .build()
        ).execute().body()
        println(body)
        return body?.get("success")?.asBoolean ?: false
    }
}