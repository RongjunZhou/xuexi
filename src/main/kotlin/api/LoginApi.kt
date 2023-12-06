package api

import com.google.gson.JsonObject
import entity.QRCodeResp
import retrofit2.Call
import retrofit2.http.GET


interface LoginApi {
    @GET("/user/qrcode/generate")
    fun generateQRCode(): Call<QRCodeResp>
}